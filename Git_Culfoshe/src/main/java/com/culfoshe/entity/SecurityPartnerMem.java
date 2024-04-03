package com.culfoshe.entity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.Part;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class SecurityPartnerMem implements UserDetails {

    private final PartnerMem partnerMem;

    public SecurityPartnerMem(PartnerMem partnerMem){
        this.partnerMem = partnerMem;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()-> "PartnerMem");
    }

    @Override
    public String getPassword() {
        return partnerMem.getPassword();
    }

    @Override
    public String getUsername() {
        return partnerMem.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
