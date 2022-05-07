package com.cloud.msa.blog.domain.dto.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommonHeader {
    private String x_auth_header;
}
