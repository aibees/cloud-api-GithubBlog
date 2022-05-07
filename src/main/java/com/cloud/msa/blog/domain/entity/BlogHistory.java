package com.cloud.msa.blog.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.Generated;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("blog_history")
public class BlogHistory {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column()
    private String title;
    private String uri;
    private String referrer;
    private LocalDateTime createTime;

    public static BlogHistory deepCopy(BlogHistory history) {
        return BlogHistory.builder()
                .title(history.getTitle())
                .uri(history.getUri())
                .referrer(history.getReferrer())
                .createTime(history.getCreateTime())
                .build();
    }
}
