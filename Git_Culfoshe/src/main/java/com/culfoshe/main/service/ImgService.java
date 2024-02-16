package com.culfoshe.main.service;

import com.culfoshe.main.repository.ImgRepository;
import com.culfoshe.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ImgService {

    private String ImgLocation;

    private final ImgRepository imgRepository;

    private final FileService fileService;
}
