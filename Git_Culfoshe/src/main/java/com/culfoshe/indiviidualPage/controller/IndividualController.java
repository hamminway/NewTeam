package com.culfoshe.indiviidualPage.controller;


import com.culfoshe.entity.IndividualMem;
import com.culfoshe.indiviidualPage.dto.IndividualPageDTO;
import com.culfoshe.indiviidualPage.dto.IndividualPageSearchDTO;
import com.culfoshe.indiviidualPage.dto.newPost.NewPostDTO;
import com.culfoshe.indiviidualPage.service.IndividualService;
import com.culfoshe.join.repository.IndividualMemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.upgrade.UpgradeProcessorInternal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/personalPage")
@Slf4j
public class IndividualController {

    private final IndividualService individualService;
    private final IndividualMemRepository individualMemRepository;

    @GetMapping(value = {"{domain}", "/{domain}/first={firstPage}&&second={secondPage}"})
    public String userPage(@PathVariable String domain, Optional<IndividualPageSearchDTO> individualPageSearchDTO,
                           @PathVariable Optional<Integer> firstPage, @PathVariable Optional<Integer> secondPage,
                           Model model){

        Pageable individualPageable = PageRequest.of(firstPage.isPresent()? firstPage.get() : 0,3);
        Pageable savedPageable = PageRequest.of(secondPage.isPresent() ? secondPage.get() : 0, 5);


        System.err.println("domain : " + domain);

        IndividualPageDTO individualPageDTO = individualService.getUserPage(domain); // 페이지 전체의 dtㅐ
        System.err.println("individualPageDTO"+ individualPageDTO);

        Page individualPostPreviewPage = individualService.getIndividualPostPreview(individualPageable, domain);//previewDTO의 page객체
        System.err.println("individualPostPreviewPage"+ individualPostPreviewPage);

        Page savedPost = individualService.getSavedPost(savedPageable, domain);//savedPost의 page객체
        System.err.println("savedPost" + savedPost);

        model.addAttribute("individualPageDTO", individualPageDTO);
        model.addAttribute("individualPostPreviewPage",individualPostPreviewPage);
        model.addAttribute("savedPost", savedPost);
        if(individualPageSearchDTO.isEmpty()){
            model.addAttribute("individualPageSearchDTO",new IndividualPageSearchDTO());
        }

        return "personalPage/individualPage";
    }

    @GetMapping(value = "{domain}/newPost")
    public String newPost(@PathVariable String domain, Model model, Principal principal){
        log.info("individual.newPost @GetMapping");
        log.info("principal.getName : ", principal.getName());
        IndividualMem user = individualMemRepository.findByIndividualDomain(domain);
        log.info("user : ", user.getEmail());

        if(!principal.getName().equals(user.getEmail())){
            model.addAttribute("errorMessage", "로그인 후 이용해주세요");
            return "";
        }
        NewPostDTO newPostDTO = new NewPostDTO();


        model.addAttribute("newPostDTO", newPostDTO);
        return "personalPage/newPost";
    }

    @PostMapping(value = "{UserUrl}/newPost")
    public String newPost(Principal principal, Model model, NewPostDTO newPostDTO){

        log.info("userName : ", principal.getName());
        return "personalPage/individualPage";
    }

}
