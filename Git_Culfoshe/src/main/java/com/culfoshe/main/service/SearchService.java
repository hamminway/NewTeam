package com.culfoshe.main.service;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.culfoshe.main.repository.ImgRepository;
import com.culfoshe.main.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;
    private final ImgRepository imgRepository;
    private final ImgService imgService;

    //검색페이지 보여줄 상품 데이터 조회
    @Transactional(readOnly = true)
    public Page<SearchPreviewDTO> getSearchPrevPage(SearchDTO searchDTO, Pageable pageable) {
        return searchRepository.getSearchPrevPage(searchDTO, pageable);
    }



}
