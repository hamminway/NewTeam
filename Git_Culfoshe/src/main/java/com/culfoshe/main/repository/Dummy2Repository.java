package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface Dummy2Repository extends JpaRepository<PartnerMem, Long>,
        QueryByExampleExecutor<PartnerMem>, SearchRepository {
}
