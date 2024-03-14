package com.culfoshe.main.controller;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.culfoshe.main.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final SearchService searchService;

    @GetMapping(value = "/")
    public String main(Model model, HttpServletRequest request) {

        // main컨트롤러에 main commend를 띄어주는 것을 넣어줘야하는데 아직 넣어주지 않아서 오류가 뜬다

        System.err.println("main test : " + request.getSession().getAttribute("Test"));
        model.addAttribute("partnerMem", new PartnerMem());
        model.addAttribute("individualPost", new IndividualPost());
        model.addAttribute("searchDTO", new SearchDTO());

        return "index";
    }

    public String SearchPage(SearchDTO searchDTO, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0 , 8);
        Page<SearchPreviewDTO> searches = searchService.getSearchPrevPage(searchDTO, pageable);

        model.addAttribute("searches", searches);
        model.addAttribute("searchDTO", searchDTO);
        model.addAttribute("maxPage" , 6);

        return "search";
    }


}
