package com.cloud.msa.blog.domain.dto.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class Response {
    private HttpStatus status;
    private Object data;
}
