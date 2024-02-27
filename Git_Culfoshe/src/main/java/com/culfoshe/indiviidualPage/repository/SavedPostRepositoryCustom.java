package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import com.culfoshe.indiviidualPage.dto.SavedPostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SavedPostRepositoryCustom {
    Page<SavedPostDTO> getSavedPost(Pageable pageable, Long id);
}
