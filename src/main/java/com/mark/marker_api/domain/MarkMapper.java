package com.mark.marker_api.domain;

import org.springframework.stereotype.Component;

@Component
public class MarkMapper {

    public MarkDTO toDTO(Mark mark){
        return new MarkDTO(
        mark.getId(),
        mark.getUrl(),
        mark.getTitle(),
        mark.getCreatedAt()
        );
    }
}
