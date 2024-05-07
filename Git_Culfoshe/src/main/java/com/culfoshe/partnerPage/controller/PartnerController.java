package com.culfoshe.partnerPage.controller;

import com.culfoshe.indiviidualPage.dto.LoginSessionDTO;
import com.culfoshe.partnerPage.dto.PartnerPageDTO;
import com.culfoshe.partnerPage.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/partnerPage")
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping(value = {"/myPage", "/{url}"})
    public String partnerPage(@PathVariable(required = false, value = "url") String url, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        LoginSessionDTO loginSessionDTO = (LoginSessionDTO) session.getAttribute("loginSessionDTO");

        /* Enumeration e = session.getAttributeNames();

        while(e.hasMoreElements()){
            System.err.println("name : " + e.nextElement());
        }

        System.err.println(loginSessionDTO); */

        String user = (url == null) ? ((LoginSessionDTO)request.getSession().getAttribute("loginSessionDTO")).getPartnerDomain() : url;
        PartnerPageDTO partnerPageDTO = partnerService.getPartnerPageDTO(user);

        System.err.println(partnerPageDTO);

        model.addAttribute("partnerPageDTO", partnerPageDTO);
        return "partner'sPage/partnerPage";
    }
}
