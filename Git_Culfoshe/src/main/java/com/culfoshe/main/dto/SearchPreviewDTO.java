package com.culfoshe.main.dto;

import com.culfoshe.entity.*;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SearchPreviewDTO extends BaseEntity {

    private String pageName;
    private String postTitle;
    private String characterName;
    private String postReview;   //한줄평
    private String imgUrl;
    private String location;

    private String storeName;    //상호명
    private String signatureMenu;
    private String storeImage;
    private String store_location;


    //individualPost 조회할 필드
    @QueryProjection
    public SearchPreviewDTO(String pageName, String postTitle, String characterName,
                            String postReview, String imgUrl, String location) {
        this.pageName = pageName;
        this.postTitle = postTitle;
        this.characterName = characterName;
        this.postReview = postReview;
        this.imgUrl = imgUrl;
        this.location = location;
    }

    //PartnerMem 조회할 필드
    @QueryProjection
    public SearchPreviewDTO(String storeName, String signatureMenu, String storeImage,
                            String store_location) {
        this.storeName = storeName;
        this.signatureMenu = signatureMenu;
        this.storeImage = storeImage;
        this.store_location = store_location;
    }

}
