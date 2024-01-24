package com.culfoshe.join.repository;

import com.culfoshe.entity.PartnerMem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerMemRepository extends JpaRepository<PartnerMem, Long> {
    PartnerMem findByEmail(String email);

    PartnerMem findByPartnerDomain(String domain);

    PartnerMem findByStoreNum(String storeNum);
}
