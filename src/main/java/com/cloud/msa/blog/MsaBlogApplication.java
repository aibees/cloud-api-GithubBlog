package com.cloud.msa.blog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsaBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsaBlogApplication.class, args);
    }
}
