package com.mark.marker_api.api;

import com.mark.marker_api.domain.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
class MarkControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    MarkRepository markRepository;

    private List<Mark> marks;

    @BeforeEach
    void setUp() {
        markRepository.deleteAllInBatch();
        marks = new ArrayList<>();
        marks.add(new Mark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        marks.add(new Mark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        marks.add(new Mark(null, "Quarkus", "https://quarkus.io", Instant.now()));
        marks.add(new Mark(null, "Micronaut", "https://micronaut.io", Instant.now()));
        marks.add(new Mark(null, "JOOQ", "https://jooq.org", Instant.now()));
        marks.add(new Mark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        marks.add(new Mark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        marks.add(new Mark(null, "Dzone", "https://dzone.com/", Instant.now()));
        marks.add(new Mark(null, "DevOpsBookmarks", "https://devopsbookmarks.com/", Instant.now()));
        marks.add(new Mark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        marks.add(new Mark(null, "Expressjs", "https://expressjs.com", Instant.now()));
        marks.add(new Mark(null, "Macrobehler", "https://macrobehler.com", Instant.now()));
        marks.add(new Mark(null, "Baeldung", "https://baeldung.com", Instant.now()));
        marks.add(new Mark(null, "Devglan", "https://devglan.com", Instant.now()));
        marks.add(new Mark(null, "Linuxize", "https://linuxize.com", Instant.now()));

        markRepository.saveAll(marks);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 15, 2, 1, false, true, true, false",
            "2, 15, 2, 2, true, false, false, true"
    })
    void shouldGetMarks(int pageNo, int totalNumberOfElements, int totalNumberOfPages, int currentPage,
                        boolean hasPrevious, boolean hasNext, boolean isFirst, boolean isLast) throws Exception {
            mvc.perform(get("/api/marks?page=" + pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalNumberOfElements", CoreMatchers.equalTo(totalNumberOfElements)))
                .andExpect(jsonPath("$.totalNumberOfPages", CoreMatchers.equalTo(totalNumberOfPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)));
    }

    @Test
    void shouldCreateMarkSuccessfully() throws Exception {
        this.mvc.perform(
                post("/api/marks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "title": "SivaLabs Blog",
                                    "url": "https://sivalabs.in"
                                }
                        """)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()));

    }
}