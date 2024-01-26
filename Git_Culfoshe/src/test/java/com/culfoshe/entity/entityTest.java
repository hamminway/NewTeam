package com.culfoshe.entity;

import com.culfoshe.join.dto.PartnerMemFormDTO;
import com.culfoshe.join.repository.PartnerMemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class entityTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PartnerMemRepository partnerMemRepository;


    @Test
    @DisplayName("entity Test")
    public void saving(){
        PartnerMemFormDTO partnerMemFormDTO = new PartnerMemFormDTO();
        partnerMemFormDTO.setStoreLocation("김해시");
        partnerMemFormDTO.setPassword("pass");
        partnerMemFormDTO.setEmail("www@naver.com");
        PartnerMem partnerMem = PartnerMemFormDTO.createPartnerMem(partnerMemFormDTO, passwordEncoder);
        partnerMemRepository.save(partnerMem);

        em.flush();
        em.clear();


        PartnerMem result = partnerMemRepository.findById(partnerMem.getPartnerMemPK().getPartnermem_id()).orElseThrow(EntityExistsException::new);

        assertEquals(partnerMem.getPartnerMemPK().getPartnermem_id(),result.getPartnerMemPK().getPartnermem_id());
        assertEquals(partnerMem.getPartnerMemPK().getStore_location(), partnerMemFormDTO.getStoreLocation());

    }
}
