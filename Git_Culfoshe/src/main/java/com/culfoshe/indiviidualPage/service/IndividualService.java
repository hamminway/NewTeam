package com.culfoshe.indiviidualPage.service;


import com.culfoshe.config.Transfer;
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

import java.util.ArrayList;
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
        IndividualMem individualMem = individualMemRepository.findByEmail(userName);
        IndividualPageDTO individualPageDTO = new IndividualPageDTO().createIndividualPageDTO(individualMem);
        return individualPageDTO;
    }

    public List<String> getCateList(IndividualMem user){
        List<String> list = Transfer.asList(user.getIndividualCategory(),"//$");
        return list;
    }

    public boolean updateUser(IndividualPageDTO individualPageDTO, String user){

        try {
            IndividualMem individualMem = individualMemRepository.findByEmail(user);
            individualMemRepository.save(individualPageDTO.updateUserByPageEdit(individualMem));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
