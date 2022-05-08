package com.cloud.msa.blog.domain.dto.blog;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistoryDto {
    private String title;
    private String uri;
    private String referrer;
    private String userAgent;
    private String createTime;
}
