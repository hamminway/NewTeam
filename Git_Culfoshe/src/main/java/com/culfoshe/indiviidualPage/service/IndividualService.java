package com.culfoshe.indiviidualPage.service;


import com.culfoshe.entity.IndividualMem;
import com.culfoshe.indiviidualPage.dto.IndividualPageDTO;
import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import com.culfoshe.indiviidualPage.dto.SavedPostDTO;
import com.culfoshe.indiviidualPage.repository.IndividualPhotoRepository;
import com.culfoshe.indiviidualPage.repository.IndividualPostCustom;
import com.culfoshe.indiviidualPage.repository.IndividualPostRepository;
import com.culfoshe.indiviidualPage.repository.SavedPostRepositoryCustom;
import com.culfoshe.join.repository.IndividualMemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IndividualService {

    private final IndividualMemRepository individualMemRepository;
    private final IndividualPostCustom individualPostCustom;
    private final IndividualPhotoRepository individualPhotoRepository;
    private final IndividualPostRepository individualPostRepository;
    private final SavedPostRepositoryCustom savedPostRepositoryCustom;

    @Transactional(readOnly = true)
    public IndividualPageDTO getUserPage(String userName){
//        log.info("IndividualService.getUserPage");
        IndividualMem individualMem = individualMemRepository.findByEmail(userName);
        System.err.println(individualMem);
        System.err.println(userName);
        log.info("userName : " , userName);
        IndividualPageDTO individualPageDTO = IndividualPageDTO.createIndividualPageDTO(individualMem);
        return individualPageDTO;
    }

    public Page<IndividualPostPreviewDTO> getIndividualPostPreview(Pageable pageable, String userName){
        log.info("IndividualService.getIndividualPostPreview");
        List<IndividualPostPreviewDTO> list = individualPostCustom.getIndividualPostPreview(pageable, userName);
        long totalCount = individualPostRepository.countPost(userName);

        for(int i = 0 ; i < list.size() ; i++){
            IndividualPostPreviewDTO postPreviewDTO =  list.get(i);
            List<String> individualPhotoList = individualPhotoRepository.findPhoto(postPreviewDTO.getPostCode());
            postPreviewDTO.setImgUrlList(individualPhotoList);
            list.set(i, postPreviewDTO);
        }

        return new PageImpl<>(list, pageable, totalCount);
    }
    public Page<SavedPostDTO> getSavedPost(Pageable pageable, String email){
        IndividualMem individualMem = individualMemRepository.findByEmail(email);
        Long id = individualMem.getId();

        return savedPostRepositoryCustom.getSavedPost(pageable, id);
    }

}
