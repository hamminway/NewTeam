package com.culfoshe.join.repository;

import com.culfoshe.entity.members.IndividualMem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualMemRepository extends JpaRepository<IndividualMem, Long> {
    IndividualMem findByEmail(String email);
}
