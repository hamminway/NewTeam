package com.culfoshe.entity;

import com.culfoshe.constant.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityIndividualMember implements UserDetails {

    private final IndividualMem individualMem;

    public SecurityIndividualMember(IndividualMem individualMem){
        this.individualMem = individualMem;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(()->"ROLE_INDIVIDUAL");
        return list;
    }

    @Override
    public String getPassword() {
        return individualMem.getPassword();
    }

    @Override
    public String getUsername() {
        return individualMem.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
