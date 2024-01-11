package com.culfoshe.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainLocationDTO {

    private Long id;
    private String locationName;    //상호명
    private String locationDetail;   //한줄평
    private String imgUrl;

    @QueryProjection
    public MainLocationDTO(Long id, String locationName,
                           String locationDetail, String imgUrl) {
        this.id = id;
        this.locationName = locationName;
        this.locationDetail = locationDetail;
        this.imgUrl = imgUrl;
    }
}
