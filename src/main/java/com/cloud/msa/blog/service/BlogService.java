package com.cloud.msa.blog.service;

import com.cloud.msa.blog.domain.dto.blog.HistoryDto;
import com.cloud.msa.blog.domain.dto.common.Response;
import com.cloud.msa.blog.domain.entity.BlogHistory;
import com.cloud.msa.blog.domain.repository.BlogHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {

    private final BlogHistoryRepository blogRepository;

    public ResponseEntity<Flux<BlogHistory>> showAllHistoryService(HistoryDto dto) {
        List<BlogHistory> historyList = new ArrayList<>();
        Flux<BlogHistory> result = blogRepository.findAll();
        result.subscribe( data -> {
            System.out.println("data in flux subscribe " + data);
            historyList.add(data);
        });
        System.out.println("list size () : " + historyList.size());
        return ResponseEntity.ok()
                .body(result);
    }

    public ResponseEntity<Response> showHistoryByTitleService(HistoryDto dto) {
        System.out.println(dto);
        return new ResponseEntity<>(
                Response.builder()
                        .status(HttpStatus.OK)
                        .data(null)
                        .build()
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<Response> saveHistoryService(HistoryDto dto) {
//        System.out.println(dto);

        LocalDateTime now = LocalDateTime.now();

        BlogHistory history = BlogHistory.builder()
                .title(dto.getTitle())
                .uri(dto.getUri())
                .referrer(dto.getReferrer())
                .userAgent(dto.getUserAgent())
                .createTime(now)
                .build();

//        System.out.println(history.toString());
        Object result = blogRepository.save(history).subscribe();

        return ResponseEntity.ok()
                .body(Response.builder().data(result).status(HttpStatus.CREATED).build());
    }
}
