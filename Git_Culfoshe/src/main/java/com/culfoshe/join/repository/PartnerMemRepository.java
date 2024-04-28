package com.culfoshe.join.repository;

import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerMemRepository extends JpaRepository<PartnerMem, PartnerMemPK> {

    PartnerMem findByEmail(String email);

    PartnerMem findByPartnerDomain(String domain);

    PartnerMem findByStoreNum(String storeNum);
}
