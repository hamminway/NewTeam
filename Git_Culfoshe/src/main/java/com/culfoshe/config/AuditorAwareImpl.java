package com.culfoshe.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userId = "";

        if(authentication != null) {
            //인증 정보에서 사용자의 이름을 추출하여 userId 변수에 저장
            userId = authentication.getName();
        }
        //AuditorAware 인터페이스를 구현한 메서드에서 사용자 Id를 리턴한다.
        return Optional.of(userId);
    }
}
