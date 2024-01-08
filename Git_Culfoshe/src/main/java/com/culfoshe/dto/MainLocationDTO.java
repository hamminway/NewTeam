package com.culfoshe.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainLocationDTO {

    private Long id;
    private String locationName;    //상호명
    private String representMenu;   //대표 메뉴
    private String address; //주소
    private String imgUrl;
//    private Integer price;    //가격


    @QueryProjection
    public MainLocationDTO(Long id, String locationName,
                           String representMenu, String address, String imgUrl) {
        this.id = id;
        this.locationName = locationName;
        this.representMenu = representMenu;
        this.address = address;
        this.imgUrl = imgUrl;
    }
}
