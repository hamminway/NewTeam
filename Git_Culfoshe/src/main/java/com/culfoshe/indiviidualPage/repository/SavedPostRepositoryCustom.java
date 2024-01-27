package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.indiviidualPage.dto.SavedPostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedPostRepositoryCustom {
    Page<SavedPostDTO> getSavedPost(Pageable pageable, Long id);
}
