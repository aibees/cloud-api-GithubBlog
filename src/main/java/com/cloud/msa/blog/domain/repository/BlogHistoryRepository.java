package com.cloud.msa.blog.domain.repository;

import com.cloud.msa.blog.domain.entity.BlogHistory;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogHistoryRepository extends R2dbcRepository<BlogHistory, Long> {

}

