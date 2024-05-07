package com.culfoshe.config.controller;

import com.culfoshe.indiviidualPage.dto.LoginSessionDTO;
import com.culfoshe.indiviidualPage.service.LoginSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final LoginSessionService loginSessionService;

    /*
    : 필터 체인을 구성하는 역힐(필터가 체인 형식으로 어떻게 작동할지를 작성하는 부분)


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }
    */


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        System.err.println("uri ?? : " +  request.getHeader("Referer"));
        LoginSessionDTO loginSessionDTO = loginSessionService.getSessionValue(authentication.getName());

        session.setAttribute("loginSessionDTO", loginSessionDTO);

        System.err.println(loginSessionDTO);

        session.setAttribute("Test", "test");
        /*System.err.println("test : "+ request.getSession().getAttribute("test"));*/
        response.sendRedirect("/");
    }


}
