package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.main.dto.MainDTO;
import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainRepositoryCustom {

    Page<MainViewDTO> getMainPage(Pageable pageable);
}
