package com.mark.marker_api.domain;

import org.springframework.stereotype.Component;

@Component
public class MarkMapper {

    public MarkDTO toDTO(Mark mark){
        MarkDTO dto = new MarkDTO();
        dto.setId(mark.getId());
        dto.setUrl(mark.getUrl());
        dto.setTitle(mark.getTitle());
        dto.setCreatedAt(mark.getCreatedAt());
        return dto;
    }
}
