package com.culfoshe.join.controller;


import com.culfoshe.entity.IndividualMem;
import com.culfoshe.join.service.KakaoLoginService;
import com.culfoshe.join.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoLoginService kakaoLoginService;

    private final AuthenticationManager authenticationManager; //springsecurity에서 제공하는 객체: 로그인 정보를 다 담고 있음.

    private final MemberService memberService;

    @Value("${kakao.default.password}")
    private String kakaoPassword;

    @GetMapping("/members/login/kakao")
    public String kakaoCallback(String code) {
        System.err.println("kakaController.kakaoCallback()");
        //인증 서버로부터 받은 CODE를 이용하여 액세스 토큰을 얻어옴
        String accessToken = kakaoLoginService.getAccessToken(code);


        IndividualMem kakaoMember = kakaoLoginService.getMemberInfo(accessToken);


        try {
            IndividualMem findMember = memberService.saveIndividualMem(kakaoMember);
            System.err.println("kakaController.kakaoCallback().findMember: "+findMember);
        } catch (IllegalStateException e) {
            memberService.loadUserByUsername(kakaoMember.getEmail());
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    kakaoMember.getEmail(), kakaoPassword
                            );

        Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";
    }
}
