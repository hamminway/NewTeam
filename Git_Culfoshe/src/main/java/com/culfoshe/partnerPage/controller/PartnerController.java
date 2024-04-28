package com.culfoshe.partnerPage.controller;

import com.culfoshe.partnerPage.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/partnerPage")
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping(value = {"/myPage", "/{url}"})
    public String partnerPage(Model model, Principal principal){


        return "partner'sPage/partnerPage";
    }
}
