package com.culfoshe.service;


import com.culfoshe.entity.LocationImg;
import com.culfoshe.repository.LocationImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationImgService {

    @Value("${locationImgLocation}")
    private String locationImgLocation;

    private final LocationImgRepository locationImgRepository;

    private final FileService fileService;

    public void saveLocationImg(LocationImg locationImg, MultipartFile locationImgFile) throws Exception {

        String oriImgName = locationImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        //파일 업로드 처리
        if(!StringUtils.isEmpty(oriImgName)) {
            //예외처리 throws
            imgName = fileService.uploadFile(locationImgLocation, oriImgName, locationImgFile.getBytes());
            imgUrl = "/images/location/" + imgName;
        }

        //이미지 정보 저장
        locationImg.updateItemImg(oriImgName, imgName, imgUrl);
        locationImgRepository.save(locationImg);
    }
}
