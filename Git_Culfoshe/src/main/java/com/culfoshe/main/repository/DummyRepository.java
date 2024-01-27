package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualMem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface DummyRepository extends JpaRepository<IndividualMem, Long>,
        QueryByExampleExecutor<IndividualMem>, SearchRepository {
}
