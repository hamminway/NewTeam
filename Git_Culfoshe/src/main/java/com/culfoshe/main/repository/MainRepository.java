package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

public interface MainRepository extends JpaRepository<IndividualPost, Long>,
        QueryByExampleExecutor<IndividualPost>, SearchRepository {
}
