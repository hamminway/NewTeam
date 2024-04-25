package com.culfoshe.main.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MainService {

    private final ImgService imgService;

//    public Long updateMain(MainDTO mainDTO, List<MultipartFile> mainImgFileList) {
//
//        IndividualPost individualPost = mainRepository.findByPostCode(mainDTO.getId());
//        PartnerMemPK partnerMem = dummyRepository.findByPartnerMemId(mainDTO.getId());
//
//        return null;
//    }

}
