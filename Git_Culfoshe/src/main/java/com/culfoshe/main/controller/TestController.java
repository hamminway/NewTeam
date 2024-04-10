package com.culfoshe.main.controller;

import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.culfoshe.main.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    SearchService searchService;


    @GetMapping(value = "/page")
    public String SearchPage(Model model, @RequestParam("number") String number, SearchDTO searchDTO) {
        System.err.println(Integer.parseInt(number));
        model.addAttribute("test", number);

        int num = Integer.parseInt(number);


        Pageable pageable = PageRequest.of(num, 5);
        Page<SearchPreviewDTO> searches = searchService.getSearchPrevPage(searchDTO, pageable);

        model.addAttribute("searches", searches);

        return "test";
    }
}
