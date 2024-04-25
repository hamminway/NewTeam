package com.culfoshe.join.service;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.SecurityIndividualMember;
import com.culfoshe.entity.SecurityPartnerMem;
import com.culfoshe.join.dto.IndividualMemFormDTO;
import com.culfoshe.join.dto.OAuthMemFormDTO;
import com.culfoshe.join.dto.PartnerMemFormDTO;
import com.culfoshe.join.repository.IndividualMemRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class    MemberService implements UserDetailsService {

    private final IndividualMemRepository individualMemRepository;
    private final PartnerMemRepository partnerMemRepository;
    private final PasswordEncoder passwordEncoder;
    private static long partnerMemberId = 100000000;

    public static long makePartnerMemberId(){

        return partnerMemberId;
    }

    public IndividualMem saveIndividualMem(@Valid IndividualMemFormDTO individualMemFormDTO) {
        IndividualMem individualMem = IndividualMemFormDTO.createIndividualMem(individualMemFormDTO, passwordEncoder);

        validateDulicateMember(individualMem.getEmail());
        return individualMemRepository.save(individualMem);
    }

    public IndividualMem saveIndividualMem(@Valid IndividualMem individualMem) {
        validateDulicateMember(individualMem.getEmail());
        return individualMemRepository.save(individualMem);
    }

    public IndividualMem updateKaKaoIndividualMem(@Valid OAuthMemFormDTO oauthMemFormDTO, String oauthMemberKey){

        IndividualMem findMember = individualMemRepository.findByEmail(oauthMemberKey);

        findMember.setName(oauthMemFormDTO.getName());
        findMember.setPhoneNum(oauthMemFormDTO.getPhoneNum());
        findMember.setIndividualDomain(oauthMemFormDTO.getIndividualDomain());

        return individualMemRepository.save(findMember);
    }

    public IndividualMem updateGoogleIndividualMem(@Valid OAuthMemFormDTO oauthMemFormDTO, String oauthMemberKey){

        IndividualMem findMember = individualMemRepository.findByEmail(oauthMemberKey);

        findMember.setPhoneNum(oauthMemFormDTO.getPhoneNum());
        findMember.setIndividualDomain(oauthMemFormDTO.getIndividualDomain());

        return individualMemRepository.save(findMember);
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

    public boolean validateDulicate(String email) {
        IndividualMem findIndividualMem = individualMemRepository.findByEmail(email);
        PartnerMem findPartnerMem = partnerMemRepository.findByEmail(email);

        if(findIndividualMem != null) {
            /*throw new IllegalStateException("이미 가입된 회원입니다.");*/
            return false;
        } else if(findPartnerMem != null){
            /*throw new IllegalStateException("이미 가입된 회원입니다.");*/
            return false;
        }

        return true; // 중복 가입한 이메일이 아닌 새로운 이메일일 경우
    }

    public boolean validateDulicateDomain(String email){
        IndividualMem findIndividualMem = individualMemRepository.findByEmail(email);
        PartnerMem findPartnerMem = partnerMemRepository.findByEmail(email);

        if(findIndividualMem != null) {
            return false;
        } else if(findPartnerMem != null){
            return false;
        }

        return true;
    }

    public boolean validateDulicateStoreNum(String storeNum){
        PartnerMem findPartnerMem = partnerMemRepository.findByStoreNum(storeNum);

        if(findPartnerMem != null){
            return false;
        }

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
                                    throws UsernameNotFoundException {

        IndividualMem individualMem = individualMemRepository.findByEmail(email);
        PartnerMem partnerMem = partnerMemRepository.findByEmail(email);

        if(individualMem == null && partnerMem == null){
            throw new UsernameNotFoundException(email);
        }

        UserDetails securityUser = individualMem != null ?
                new SecurityIndividualMember(individualMem)
                : new SecurityPartnerMem(partnerMem);;

       return User.builder()
               .username(securityUser.getUsername())
               .password(securityUser.getPassword())
               .roles(securityUser.getAuthorities().toString())
               .build();
    }




}
