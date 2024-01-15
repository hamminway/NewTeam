package com.culfoshe.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainViewDTO {

    private Long id;
    private String storeName;    //상호명
    private String storeReview;   //한줄평
    private String storeImage;

    @QueryProjection
    public MainViewDTO(Long id, String storeName,
                       String storeReview, String storeImage) {
        this.id = id;
        this.storeName = storeName;
        this.storeReview = storeReview;
        this.storeImage = storeImage;
    }
}
