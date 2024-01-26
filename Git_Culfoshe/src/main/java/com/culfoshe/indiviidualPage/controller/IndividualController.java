package com.culfoshe.indiviidualPage.controller;


import com.culfoshe.indiviidualPage.dto.IndividualPageDTO;
import com.culfoshe.indiviidualPage.dto.IndividualPageSearchDTO;
import com.culfoshe.indiviidualPage.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.http11.upgrade.UpgradeProcessorInternal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class IndividualController {

    private final IndividualService individualService;

    @GetMapping(value = {"{UserUrl}", "/{UserUrl}/first={firstPage}&&second={secondPage}"})
    public String userPage(@PathVariable String UserUrl, IndividualPageSearchDTO individualPageSearchDTO,
                           @PathVariable Optional<Integer> firstPage, @PathVariable Optional<Integer> secondPage,
                           Model model){

        Pageable individualPageable = PageRequest.of(firstPage.isPresent()? firstPage.get() : 0,3);
        Pageable savedPageable = PageRequest.of(secondPage.isPresent() ? secondPage.get() : 0, 5);


        IndividualPageDTO individualPageDTO = individualService.getUserPage(UserUrl); // 페이지 전체의 dto
        Page individualPostPreviewPage = individualService.getIndividualPostPreview(individualPageable, UserUrl);//previewDTO의 page객체
        Page savedPost = individualService.getSavedPost(savedPageable, UserUrl);//savedPost의 page객체


        model.addAttribute("individualPageDTO", individualPageDTO);
        model.addAttribute("individualPostPreviewPage",individualPostPreviewPage);
        model.addAttribute("savedPost", savedPost);

        return "personalPage/individualPage";
    }

}
