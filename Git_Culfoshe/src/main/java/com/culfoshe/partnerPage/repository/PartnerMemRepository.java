package com.culfoshe.partnerPage.repository;

import com.culfoshe.entity.PartnerMem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerMemRepository extends JpaRepository<PartnerMem, Long> {
    PartnerMem findByEmail(String email);
}
