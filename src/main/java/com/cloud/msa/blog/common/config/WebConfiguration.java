package com.cloud.msa.blog.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfiguration implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/blog/history")
                .allowedMethods(HttpMethod.POST.name())
                .allowedOrigins("http://localhost:4000")
                .allowedOrigins("https://aibees.github.io");
    }
}
