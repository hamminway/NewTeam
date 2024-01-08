package com.culfoshe.service;



import com.culfoshe.dto.LocationFormDTO;
import com.culfoshe.entity.Location;
import com.culfoshe.entity.LocationImg;
import com.culfoshe.repository.LocationImgRepository;
import com.culfoshe.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationImgService locationImgService;
    private final LocationImgRepository locationImgRepository;

    public Long saveLocation(LocationFormDTO locationFormDTO,
                             List<MultipartFile> locationImgFileList) throws Exception {

        Location location = locationFormDTO.createLocation();
        locationRepository.save(location);

        for(int i=0; i<locationImgFileList.size(); i++){
            LocationImg locationImg = new LocationImg();
            locationImg.setLocation(location);

            if(i == 0) {
                locationImg.setRepImgYn("Y");
            } else {
                locationImg.setRepImgYn("N");
            }
            // throws 예외 처리
            locationImgService.saveLocationImg(locationImg, locationImgFileList.get(i));
        }

        return location.getId();
    }
}
