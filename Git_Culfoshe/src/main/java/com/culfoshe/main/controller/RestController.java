package com.culfoshe.main.controller;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.culfoshe.main.service.MainService;
import com.culfoshe.main.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private MainService mainService;
    private SearchService searchService;

    @GetMapping(value = "/searches/searchingForm")
    public Page<SearchPreviewDTO> getSearchPrevPage(Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0 , 8);
        return searchService.getSearchPrevPage(new SearchDTO(), pageable);
    }

    //원하는 몇개를 담을지
    //지역별 추천에서 사용
}
