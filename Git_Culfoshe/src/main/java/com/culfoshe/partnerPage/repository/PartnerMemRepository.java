package com.culfoshe.partnerPage.repository;

import com.culfoshe.entity.members.IndividualMem;
import com.culfoshe.entity.members.PartnerMem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerMemRepository extends JpaRepository<PartnerMem, Long> {
    PartnerMem findByEmail(String email);
}
