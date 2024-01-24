package com.culfoshe.main.dto;

import com.culfoshe.entity.*;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainViewDTO {

    private String storeName;
    private String signatureMenu;
    private String postReview;
    private String imgUrl;

    public MainViewDTO(PartnerMem partnerMem,
                       IndividualPost individualPost, String imgUrl) {
        this.storeName = partnerMem.getStoreName();
        this.signatureMenu = partnerMem.getSignatureMenu();
        this.postReview = individualPost.getPostReview();
        this.imgUrl = imgUrl;
    }

}
