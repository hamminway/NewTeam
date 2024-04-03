package com.culfoshe.main.controller;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.main.dto.MainDTO;
import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.culfoshe.main.service.MainService;
import com.culfoshe.main.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    private final SearchService searchService;

    @GetMapping(value = "/")
    public String main(SearchDTO searchDTO, MainDTO mainDTO, Model model, Optional<Integer> page, PartnerMem partnerMem, IndividualPost individualPost) {
        // main컨트롤러에 main commend를 띄어주는 것을 넣어줘야하는데 아직 넣어주지 않아서 오류가 뜬다
//        Pageable pageable = PageRequest.of( 0, 6);
//        Page<MainViewDTO> mainViewDTOS = getPage(pageable);

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<MainViewDTO> mainViewDTOS = mainService.getMainPage(pageable);

        model.addAttribute("mainViewDTOs", null);   //임시로 null을 넣어줌 (원래는 mainViewDTOS)
        model.addAttribute("searchDTO", searchDTO);

        return "index";
    }
//    private Page<MainViewDTO> getPage(Pageable pageable) {
//        List<MainViewDTO> content = new ArrayList<>();
//        PartnerMem partnerMem = new PartnerMem();
//        partnerMem.setStoreName("testName");
//        partnerMem.setSignatureMenu("testMenu");
//
//        long l = 6;
//        for (int i = 0; i < 6; i++) {
//            IndividualPost individualPost = new IndividualPost();
//            individualPost.setPostReview("test_review" + i);
//            MainViewDTO mainViewDTO = new MainViewDTO(partnerMem,
//                    individualPost, "String imgUrl");
//            content.add(mainViewDTO);
//        }
//        return new PageImpl<MainViewDTO>(content, pageable, l);

//    }


}
