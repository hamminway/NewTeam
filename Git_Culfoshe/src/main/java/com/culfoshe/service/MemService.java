package com.culfoshe.service;

import com.culfoshe.join.dto.IndividualMemFormDTO;
import com.culfoshe.partnerPage.dto.PartnerMemFormDTO;
import com.culfoshe.entity.members.IndividualMem;
import com.culfoshe.entity.members.PartnerMem;
import com.culfoshe.repository.members.IndividualMemRepository;
import com.culfoshe.repository.members.PartnerMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemService implements UserDetailsService {

    private final IndividualMemRepository individualMemRepository;
    private final PartnerMemRepository partnerMemRepository;
    private final PasswordEncoder passwordEncoder;

    public IndividualMem saveIndividualMem(IndividualMemFormDTO individualMemFormDTO) {
        IndividualMem individualMem = IndividualMemFormDTO.createIndividualMem(individualMemFormDTO, passwordEncoder);

        validateDulicateMember(individualMem.getEmail());
        return individualMemRepository.save(individualMem);
    }

    public PartnerMem savePartnerMem(PartnerMemFormDTO partnerMemFormDTO){
        PartnerMem partnerMem = PartnerMemFormDTO.createPartnerMem(partnerMemFormDTO, passwordEncoder);

        validateDulicateMember(partnerMemFormDTO.getEmail());
        return partnerMemRepository.save(partnerMem);
    }

    private void validateDulicateMember(String email) {
        IndividualMem findIndividualMem = individualMemRepository.findByEmail(email);
        PartnerMem findPartnerMem = partnerMemRepository.findByEmail(email);

        if(findIndividualMem != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        } else if(findPartnerMem != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email)
                                    throws UsernameNotFoundException {
        IndividualMem individualMem = individualMemRepository.findByEmail(email);
        PartnerMem partnerMem = partnerMemRepository.findByEmail(email);

       if(individualMem == null){
           throw new UsernameNotFoundException(email);
       } else if(partnerMem == null) {
           throw new UsernameNotFoundException(email);
       }

       return User.builder()
               .username(individualMem.getEmail())
               .password(individualMem.getPassword())
               .build();
    }
}
