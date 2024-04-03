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

    public MainViewDTO() {

    }
//    private
    @QueryProjection
    public MainViewDTO(String storeName, String signatureMenu, String postReview,
                       String imgUrl) {
        this.storeName = storeName;
        this.signatureMenu = signatureMenu;
        this.postReview = postReview;
        this.imgUrl = imgUrl;
    }

}
