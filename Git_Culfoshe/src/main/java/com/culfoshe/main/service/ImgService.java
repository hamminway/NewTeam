package com.culfoshe.main.service;

import com.culfoshe.entity.IndividualPhoto;
import com.culfoshe.entity.StorePhoto;
import com.culfoshe.main.repository.ImgRepository;
import com.culfoshe.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class ImgService {

    private String imgLocation;
    private final ImgRepository imgRepository;
    private final FileService fileService;

    //이미지 저장 메서드
//    public void saveImg(StorePhoto storePhoto, MultipartFile imgFile) throws Exception {
//        String oriImgName = imgFile.getOriginalFilename();
//        String imgName = "";
//        String imgUrl = "";
//
//        if(!StringUtils.isEmpty(oriImgName)) {
//            imgName = fileService.uploadFile(imgLocation, oriImgName, imgFile.getBytes());
//            imgUrl = "/images/location/" + imgName;
//        }
//
//        storePhoto.updateImg(oriImgName, imgName, imgUrl);
//        imgRepository.save();
//    }

    //이미지 변경 메서드


}
