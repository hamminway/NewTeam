package com.culfoshe.join.service;

import com.culfoshe.join.dto.IndividualMemFormDTO;
import com.culfoshe.join.dto.PartnerMemFormDTO;
import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.join.repository.IndividualMemRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final IndividualMemRepository individualMemRepository;
    private final PartnerMemRepository partnerMemRepository;
    private final PasswordEncoder passwordEncoder;
    private static long partnerMemberId = 100000000;

    public static long makePartnerMemberId(){
//        if()
        return partnerMemberId;
    }

    public IndividualMem saveIndividualMem(@Valid IndividualMemFormDTO individualMemFormDTO) {
        System.err.println("memberService 동작");
        IndividualMem individualMem = IndividualMemFormDTO.createIndividualMem(individualMemFormDTO, passwordEncoder);

        validateDulicateMember(individualMem.getEmail());
        return individualMemRepository.save(individualMem);
    }

    public PartnerMem savePartnerMem(PartnerMemFormDTO partnerMemFormDTO){
        PartnerMem partnerMem = PartnerMemFormDTO.createPartnerMem(partnerMemFormDTO, passwordEncoder);

        System.err.println("memberService.savePartnerMem.dto" + partnerMemFormDTO);
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
