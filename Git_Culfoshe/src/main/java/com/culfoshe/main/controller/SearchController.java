package com.culfoshe.main.controller;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.culfoshe.main.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

//    @GetMapping(value = "/search")
//    public @ResponseBody SearchPreviewDTO search(@RequestBody SearchPreviewDTO searchPreviewDTO) {
//        return searchService.getSearchPrevPage(searchPreviewDTO);
//    }

    @GetMapping(value = "/searchList")
    public String SearchPage(SearchDTO searchDTO, Optional<Integer> page, Model model) {

        System.err.println(searchDTO);
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0 , 5);
        Page<SearchPreviewDTO> searches = searchService.getSearchPrevPage(searchDTO, pageable);

        for(int i = 0 ; i < searches.getContent().size() ; i++){
            System.err.println(searches.getContent().get(i));
        }
        System.err.println("getTotalElements : " + searches.getTotalElements());
        System.err.println("getTotalPages : " + searches.getTotalPages());
        System.err.println("contentSize : " + searches.getContent().size());

        model.addAttribute("searches", searches);
        model.addAttribute("searchDTO", searchDTO);
        model.addAttribute("maxPage" , 6);

        return "search/searchingForm";
    }

}
