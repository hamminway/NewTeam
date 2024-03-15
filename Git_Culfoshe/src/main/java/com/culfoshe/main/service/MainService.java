package com.culfoshe.main.service;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import com.culfoshe.main.dto.MainDTO;
import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.repository.DummyRepository;
import com.culfoshe.main.repository.ImgRepository;
import com.culfoshe.main.repository.MainRepository;
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

    private final MainRepository mainRepository;
    private final DummyRepository dummyRepository;
    private final ImgRepository imgRepository;
    private final ImgService imgService;

//    public Long updateMain(MainDTO mainDTO, List<MultipartFile> mainImgFileList) {
//
//        IndividualPost individualPost = mainRepository.findByPostCode(mainDTO.getId());
//        PartnerMemPK partnerMem = dummyRepository.findByPartnerMemId(mainDTO.getId());
//
//        return null;
//    }

    @Transactional(readOnly = true)
    public Page<MainViewDTO> getMainPage(Pageable pageable) {
        return mainRepository.getMainPage(pageable);
    }

}
