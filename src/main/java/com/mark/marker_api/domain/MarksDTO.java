package com.mark.marker_api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class MarksDTO {
    private List<MarkDTO> data;
    private long totalNumberOfElements;
    private int totalNumberOfPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFist;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasPrevious;
    private boolean hasNext;

    public MarksDTO(Page<MarkDTO> markPage){
        this.data = markPage.getContent();
        this.totalNumberOfElements = markPage.getTotalElements();
        this.totalNumberOfPages = markPage.getTotalPages();
        this.currentPage = markPage.getNumber() + 1;
        this.isFist = markPage.isFirst();
        this.isLast = markPage.isLast();
        this.hasPrevious = markPage.hasPrevious();
        this.hasNext = markPage.hasNext();
    }
}
