package com.culfoshe.join.repository;

import com.culfoshe.entity.IndividualMem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualMemRepository extends JpaRepository<IndividualMem, Long> {
    IndividualMem findByEmail(String email);

    IndividualMem findByIndividualDomain(String domain);

}
