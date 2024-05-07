package com.culfoshe.main.service;


import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.repository.MainRepository;
import com.culfoshe.main.repository.MainRepositoryCustom;
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
    private final MainRepository mainRepository;

    @Transactional(readOnly = true)
    public Page<MainViewDTO> getMainViewDTOPage(String location, Pageable pageable) {
        return mainRepository.getMainPage(location, pageable);
    }

}
