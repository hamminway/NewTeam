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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/personalPage")
@Slf4j
public class IndividualController {

    private final IndividualService individualService;
    private final IndividualMemRepository individualMemRepository;

    @GetMapping(value = {"/myPage","/{url}"})
    public String userPage( Optional<String> url,
                           Model model, HttpServletRequest request, Principal principal){


        String userName = url.isPresent()? url.toString() : principal.getName();
        IndividualPageDTO individualPageDTO = individualService.getUserPage(userName);
        boolean isMyPage = false;
        if(principal!=null){
            isMyPage = principal.getName().equals(userName)? true : false;
        }
        model.addAttribute("isMyPage", isMyPage);
        model.addAttribute("individualPageDTO", individualPageDTO);

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

    //프로필 수정할때 url
    @GetMapping(value = "/myPage/edit")
    public String editPage(Principal principal, IndividualPageDTO individualPageDTO, Model model){
        individualPageDTO = individualService.getUserPage(principal.getName());
        model.addAttribute("individualPageDTO", individualPageDTO);
        return "personalPage/profile_replaceInput";
    }
    //프로필 수정완료 btn
    @PostMapping(value = "/myPage/edit")
    public String editSubmit(Principal principal, IndividualPageDTO individualPageDTO, Model model, HttpServletResponse response){
        String user = principal.getName();
        if(individualService.updateUser(individualPageDTO, user)){
            model.addAttribute("individualPageDTO", individualPageDTO);
        }else{
            response.setStatus(403);
        }
        return "personalPage/profile_replace";
    }
    //프로필 수정 취소
    @GetMapping(value = "/myPage/edit/close")
    public String closeEdit(Principal principal, IndividualPageDTO individualPageDTO, Model model){
        individualPageDTO = individualService.getUserPage(principal.getName());
        model.addAttribute("individualPageDTO", individualPageDTO);
        return "personalPage/profile_replace";
    }
    //side 수정
    @GetMapping(value = "/myPage/editCate")
    public String editCate(Principal principal, Model model, LoginSessionDTO loginSessionDTO){
        List cateList = individualService.getCateList(loginSessionDTO.getIndividualMem());
        model.addAttribute("cateList", cateList);
        return "personalPage/replace/myPage_sideReplaceInput";
    }


    @PostMapping(value = "/myPage/editCate")
    public ResponseEntity<String> editCate(){

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
