package com.culfoshe.join.dto;

import com.culfoshe.entity.IndividualMem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

//UserDetails: 사용자의 인증 정보와 권한을 담고 있는 객체
//OAuth2User: OAuth2를 사용하여 인증된 사용자의 정보를 제공

@Getter @Setter @ToString
public class PrincipalDetails implements UserDetails, OAuth2User {

    private IndividualMem individualMem;

    //구글에서 조회한 사용자의 정보를 저장하기 위한 멤버 변수
    private Map<String, Object> attributes;

    public PrincipalDetails(IndividualMem individualMem) {
        this.individualMem = individualMem;
    }

    //member 객체와 사용자의 정보를 담은 map을 매개변수로 받는 생성자
    //OAuth를 이용한 로그인 시, 사용할 생성자 (Google에서 정보를 넘겨받아 로그인할 때를 의미하는 거임.)
    public PrincipalDetails(IndividualMem individualMem, Map<String, Object> attributes) {
        this.individualMem = individualMem;
        this.attributes = attributes;
    }

    //member 객체의 이름을 반환
    @Override
    public String getName() {
        return individualMem.getName();
    }

    //구글에서 조회한 사용자의 정보가 저장된 map을 반환(구글에서 map 형태를 반환하기에 꼬옥 map으로 작성해야 함.)
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //부여된 권한의 목록을 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //member 객체의 비밀 번호를 반환
    @Override
    public String getPassword() {
        return individualMem.getPassword();
    }

    //member 객체의 이메일을 반환
    @Override
    public String getUsername() {
        return individualMem.getEmail();
    }

    //계정이 만료 되었는지 여부를 확인
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //계정이 잠겨있는지 여부를 확인
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //자격 증명이 만료되었는지 확인(자격이 있는지, 없는지)
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정이 활성화 되어 있는지 확인
    @Override
    public boolean isEnabled() {
        return false;
    }
}
