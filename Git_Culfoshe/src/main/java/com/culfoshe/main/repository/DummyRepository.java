package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface DummyRepository extends JpaRepository<PartnerMem, Long>,
        QueryByExampleExecutor<PartnerMem>, SearchRepository {

//    PartnerMemPK findByPartnerMemId(Long PartnerMemId);

}
