package com.culfoshe.main.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainViewDTO {

    private Long id;
    private String storeName;    //상호명
    private String PostReview;   //한줄평
    private String storeImage;

    @QueryProjection
    public MainViewDTO(Long id, String storeName,
                       String PostReview, String storeImage) {
        this.id = id;
        this.storeName = storeName;
        this.PostReview = PostReview;
        this.storeImage = storeImage;
    }
}
