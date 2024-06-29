package com.mark.marker_api;

import com.mark.marker_api.domain.*;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final MarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Mark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        repository.save(new Mark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        repository.save(new Mark(null, "Quarkus", "https://quarkus.io", Instant.now()));
        repository.save(new Mark(null, "Micronaut", "https://micronaut.io", Instant.now()));
        repository.save(new Mark(null, "JOOQ", "https://jooq.org", Instant.now()));
        repository.save(new Mark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        repository.save(new Mark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        repository.save(new Mark(null, "Dzone", "https://dzone.com/", Instant.now()));
        repository.save(new Mark(null, "DevOpsBookmarks", "https://devopsbookmarks.com/", Instant.now()));
        repository.save(new Mark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        repository.save(new Mark(null, "Expressjs", "https://expressjs.com", Instant.now()));
        repository.save(new Mark(null, "Macrobehler", "https://macrobehler.com", Instant.now()));
        repository.save(new Mark(null, "Baeldung", "https://baeldung.com", Instant.now()));
        repository.save(new Mark(null, "Devglan", "https://devglan.com", Instant.now()));
        repository.save(new Mark(null, "Linuxize", "https://linuxize.com", Instant.now()));

    }
}
