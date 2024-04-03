package com.culfoshe.indiviidualPage.controller;


import com.culfoshe.entity.IndividualMem;
import com.culfoshe.indiviidualPage.dto.IndividualPageDTO;
import com.culfoshe.indiviidualPage.dto.IndividualPageSearchDTO;
import com.culfoshe.indiviidualPage.dto.LoginSessionDTO;
import com.culfoshe.indiviidualPage.dto.newPost.NewPostDTO;
import com.culfoshe.indiviidualPage.service.IndividualService;
import com.culfoshe.join.repository.IndividualMemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.upgrade.UpgradeProcessorInternal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/personalPage")
@Slf4j
public class IndividualController {

    private final IndividualService individualService;
    private final IndividualMemRepository individualMemRepository;

    @GetMapping(value = {"/myPage"})
    public String userPage( Optional<IndividualPageSearchDTO> individualPageSearchDTO,
                           Model model, HttpServletRequest request, Principal principal){

        String userName = principal.getName();
        individualService.getUserPage(userName);
        if(individualPageSearchDTO.isEmpty()){
            model.addAttribute("individualPageSearchDTO",new IndividualPageSearchDTO());
        }

        return "personalPage/individualPage";
    }

    @GetMapping(value = "/newPost")
    public String newPost(Model model, Principal principal, HttpServletResponse response)
    throws IOException {
        log.info("individual.newPost @GetMapping");
        String email = principal.getName();
        IndividualMem user = individualMemRepository.findByEmail(email);

//        model.addAttribute("newPostDTO", newPostDTO);
        return "personalPage/newIndividualPost";
    }

    @PostMapping(value = "/newPost")
    public String newPost(Principal principal, Model model, NewPostDTO newPostDTO){

        System.err.println(newPostDTO);

        log.info("userName : ", principal.getName());
        return "personalPage/individualPage";
    }

}
