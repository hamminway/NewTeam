package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


public interface SearchRepository  {

    Page<SearchPreviewDTO> getSearchPrevPage(SearchDTO searchDTO, Pageable pageable);
}
