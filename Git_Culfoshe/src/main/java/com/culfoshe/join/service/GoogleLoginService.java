package com.culfoshe.join.service;

import com.culfoshe.constant.OAuthType;
import com.culfoshe.entity.IndividualMem;
import com.culfoshe.join.dto.PrincipalDetails;
import com.culfoshe.join.repository.IndividualMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GoogleLoginService extends DefaultOAuth2UserService {

    private final IndividualMemRepository individualMemRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${google.default.password}")
    private String googlePassword;

    //1. 사용자가 구글에 로그인을 성공하면 구글은 인증 클라이언트에 CODE 정보를 전달함.
    //2. OAuth2 클라이언트는 code를 기반으로 액세스 토큰을 요청하고 액세스 토큰이 저장된 OAuth2UserRequest를 받음.
    //3. OAuth2 클라이언트가 OAuth2UserRequest를 매개변수로 넘기면서 loadUser 메서드를 호출함.

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        //액세스 토큰이 저장된 userRequert를 이용하여
        //구글로부터 회원 정보를 받아옴.
        OAuth2User oAuth2User = super.loadUser(userRequest);

        //구글이 전달해준 정보를 바탕으로 회원 정보를 구성
        String userName = oAuth2User.getAttribute("name");
        String userEmail = oAuth2User.getAttribute("email");
        String password = googlePassword;

        IndividualMem findUser;

        try {
            //회원가입이 되어있는 사용자인지 확인
            findUser = individualMemRepository.findByEmail(userEmail);
        } catch (NullPointerException e) {
            //회원가입이 되어있지 않으면 member객체를 생성
            findUser = new IndividualMem();
        }

        //회원가입이 되어있지 않으면 member 객체에 데이터를 설정
        if(findUser == null) {
            IndividualMem individualMem = new IndividualMem();
            individualMem.setName(userName);
            individualMem.setEmail(userEmail);
            individualMem.setPassword(passwordEncoder.encode(password));
            individualMem.setOauth(OAuthType.GOOGLE);

            findUser = individualMem;
            individualMemRepository.save(individualMem);
        }

        //OAuth2 클라이언트가 PrincipalDetails에 설정된 정보를 이용하여 authencation 객체를 SecurityContext에 자동으로 등록함.
        return new PrincipalDetails(findUser, oAuth2User.getAttributes());

    }
}
