package com.culfoshe.indiviidualPage.controller;


import com.culfoshe.join.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/edit")
@RequiredArgsConstructor
@Slf4j
public class EditIndividualController {
    private final MemberService memberService;


    @PostMapping(value = "/{email}")
    public @ResponseBody ResponseEntity<String> editIndividual(){


        return null;
    }


}
