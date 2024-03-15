package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface MainRepository extends JpaRepository<IndividualPost, Long>,
        QueryByExampleExecutor<IndividualPost>, MainRepositoryCustom, SearchRepository {

    IndividualPost findByPostCode(Long postCode);
}
