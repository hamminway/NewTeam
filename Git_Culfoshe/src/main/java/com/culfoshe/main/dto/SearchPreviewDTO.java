package com.culfoshe.main.dto;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchPreviewDTO {

    private Long id;
    private String storeName;    //상호명
    private String postTitle;
    private String postReview;   //한줄평
    private String imgUrl;

    private String pageName;
    private String characterName;
    private String location;


    //individualPost 조회할 필드
    public SearchPreviewDTO(IndividualMem individualMem, IndividualPost individualPost) {
        this.pageName = individualMem.getPageName();
        this.characterName = individualMem.getCharacterName();
        this.postTitle = individualPost.getPostTitle();
        this.postReview = individualPost.getPostReview();
    }

    //PartnerMem 조회할 필드
    public SearchPreviewDTO(PartnerMem partnerMem, PartnerMemPK partnerMemPK) {
        this.storeName = partnerMem.getStoreName();
        this.location = partnerMemPK.getStore_location();
    }

    @QueryProjection
    public SearchPreviewDTO(Long id, String storeName, String postTitle,
                            String postReview, String imgUrl, String pageName,
                            String characterName) {
        this.id = id;
        this.storeName = storeName;
        this.postTitle = postTitle;
        this.postReview = postReview;
        this.imgUrl = imgUrl;

        this.pageName = pageName;
        this.characterName = characterName;
    }



}
