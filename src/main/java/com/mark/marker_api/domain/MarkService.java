package com.mark.marker_api.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository repository;
    private final MarkMapper markMapper;

    @Transactional(readOnly = true)
    public MarksDTO getMarks(Integer page) {
        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<MarkDTO> markPage = repository.findMarks(pageable);
        return new MarksDTO(markPage);
    }

    @Transactional(readOnly = true)
    public MarksDTO searchMarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
//        Page<MarkDTO> markPage = repository.searchMarks(query, pageable);
        Page<MarkDTO> markPage = repository.findByTitleContainsIgnoreCase(query, pageable);
        return new MarksDTO(markPage);
    }

    public MarkDTO createMark(CreateMarkRequest request) {
        Mark mark = new Mark(null, request.getTitle(), request.getUrl(), Instant.now());
        Mark savedMark = repository.save(mark);
        return markMapper.toDTO(savedMark);
    }
}
