package com.culfoshe.join.repository;

import com.culfoshe.entity.PartnerMem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerMemRepository extends JpaRepository<PartnerMem, Long> {
    PartnerMem findByEmail(String email);
//    Optional<PartnerMem>
}
