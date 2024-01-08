package com.culfoshe.dto;

import com.culfoshe.entity.LocationImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class LocationImgDTO {

    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;
    private static ModelMapper modelMapper = new ModelMapper();

    public static  LocationImgDTO of(LocationImg locationImg) {
        //modelMapper.map(매핑되는 객체, 매핑 결과로 생성할 객체의 클래스)
        return modelMapper.map(locationImg, LocationImgDTO.class);
    }
}
