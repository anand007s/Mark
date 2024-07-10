package com.mark.marker_api.api;

import com.mark.marker_api.domain.CreateMarkRequest;
import com.mark.marker_api.domain.MarkDTO;
import com.mark.marker_api.domain.MarksDTO;
import com.mark.marker_api.domain.MarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
public class MarkController {
    private final MarkService markService;

    @GetMapping
    public MarksDTO getMarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
                             @RequestParam(name = "query", defaultValue = "") String query) {
        if(query == null && query.trim().length() == 0) {
            return markService.getMarks(page);
        }
        return markService.searchMarks(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarkDTO createMark(@RequestBody @Valid CreateMarkRequest request) {
        return markService.createMark(request);

    }
}
