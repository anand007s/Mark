package com.mark.marker_api.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class MarkDTO {
    private List<Mark> data;
    private long totalNumberOfElements;
    private int totalNumberOfPages;
    private int currentPage;
    private boolean isFist;
    private boolean isLast;
    private boolean hasPreviour;
    private boolean hasNext;

    public MarkDTO(Page marks){
        this.data = marks.getContent();
        this.totalNumberOfElements = marks.getTotalElements();
        this.totalNumberOfPages = marks.getTotalPages();
        this.currentPage = marks.getNumber() + 1;
        this.isFist = marks.isFirst();
        this.isLast = marks.isLast();
        this.hasPreviour = marks.hasPrevious();
        this.hasNext = marks.hasNext();
    }
}
