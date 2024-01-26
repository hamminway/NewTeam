package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import com.culfoshe.indiviidualPage.dto.SavedPostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SavedPostRepositoryCustom {
    Page<SavedPostDTO> getSavedPost(Pageable pageable, Long id);
}
