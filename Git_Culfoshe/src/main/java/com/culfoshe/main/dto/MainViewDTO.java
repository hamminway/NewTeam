package com.culfoshe.main.dto;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.*;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class MainViewDTO {

    private String storeName;
    private String signatureMenu;
    private String postReview;
    private String imgUrl;

    @QueryProjection
    public MainViewDTO(PartnerMem partnerMem,
                   IndividualPost individualPost) {
        this.storeName = partnerMem.getStoreName();
        this.signatureMenu = partnerMem.getSignatureMenu();
        this.postReview = individualPost.getPostReview();
        this.imgUrl = partnerMem.getStoreImage();
    }

}
