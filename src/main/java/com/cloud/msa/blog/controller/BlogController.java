package com.cloud.msa.blog.controller;

import com.cloud.msa.blog.domain.dto.blog.HistoryDto;
import com.cloud.msa.blog.domain.dto.common.Response;
import com.cloud.msa.blog.domain.entity.BlogHistory;
import com.cloud.msa.blog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/history")
    public ResponseEntity<Response> saveBlogHistory(@RequestBody HistoryDto dto) {
        return blogService.saveHistoryService(dto);
    }

    @GetMapping(path="/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<BlogHistory> showAllBlogHistory(HistoryDto dto) {
        return blogService.showAllHistoryService(dto);
    }

    @GetMapping("/history/:title")
    public ResponseEntity<Response> showBlogHistory(HistoryDto dto) {
        return blogService.showHistoryByTitleService(dto);
    }
}
