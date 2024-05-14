package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualPostCustom {

    List<IndividualPostPreviewDTO> getIndividualPostPreview(Pageable pageable, String userName);
    List<IndividualPostPreviewDTO> getIndividualPostPreviewForPartnerMem(Pageable pageable, String partnerDomain);
    List<IndividualPost> getIndividualPostPreviewRe(Pageable pageable, String domain);

}
