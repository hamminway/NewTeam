package com.culfoshe.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberFormDTO memberFormDTO = new MemberFormDTO();

        memberFormDTO.setId("test");
        memberFormDTO.setPassword("1234");
        memberFormDTO.setName("이포쉐");
        memberFormDTO.setEmail("test@test.com");
        memberFormDTO.setPhoneNum("010-1111-1111");
        memberFormDTO.setCellPNum("052-111-1111");
        memberFormDTO.setInterest("밥먹기");
        memberFormDTO.setInterestArea("울산");
        memberFormDTO.setIndividualMem("개인");
        memberFormDTO.setPartnerMem("관리자");

        return Member.createMember(memberFormDTO, passwordEncoder);

    }

    @Test
    @DisplayName("회원 가입 테스트")
    public void saveMemberTest() {

        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        assertEquals(member.getId(), savedMember.getId());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getPhoneNum(), savedMember.getPhoneNum());
        assertEquals(member.getCellPNum(), savedMember.getCellPNum());
        assertEquals(member.getInterest(), savedMember.getInterest());
        assertEquals(member.getInterestArea(), savedMember.getInterestArea());
        assertEquals(member.getIndividualMem(), savedMember.getIndividualMem());
        assertEquals(member.getPartnerMem(), savedMember.getPartnerMem());
        assertEquals(member.getRole(), savedMember.getRole());

    }

    @Test
    @DisplayName("중복 회원 테스트")
    public void saveDuplicateMemberTest() {

        Member member1 = createMember();
        Member member2 = createMember();

        memberService.saveMember(member1);

        try{
            memberService.saveMember(member2);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("이미 가입한 회원입니다.", e.getMessage());

        }

    }
}