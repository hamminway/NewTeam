package com.culfoshe.main.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainViewDTO {

    private Long id;
    private String storeName;    //상호명
    private String postReview;   //한줄평
    private String imgUrl;

    @QueryProjection
    public MainViewDTO(Long id, String storeName,
                       String postReview, String imgUrl) {
        this.id = id;
        this.storeName = storeName;
        this.postReview = postReview;
        this.imgUrl = imgUrl;
    }
}
