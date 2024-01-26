package com.culfoshe.join.repository;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.indiviidualPage.dto.IndividualPageDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualMemRepository extends JpaRepository<IndividualMem, Long> {
    IndividualMem findByEmail(String email);
    IndividualMem findByIndividualDomain(String domain);
}
