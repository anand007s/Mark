package com.mark.marker_api.api;

import com.mark.marker_api.domain.MarkDTO;
import com.mark.marker_api.domain.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@RequiredArgsConstructor
public class MarkController {
    private final MarkService markService;

    @GetMapping
    public MarkDTO getMarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return markService.getMarks(page);
    }
}
