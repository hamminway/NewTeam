package com.culfoshe.main.dto;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SearchPreviewDTO {

//    private Long id; --> 필요없는값 --> view로 가는 데이터 --> view를 보는 client는 id값을 알 필요x
//    private String pageName;    // 개인 테이블 조회 view의 어디서 쓰지?
    private String postTitle;   // 개인 포스트 테이블 조회시 view의 타이틀 역할
    private String characterName; // 개인 포스트 테이블 조회시 글쓴이
    private String postReview;   //개인 포스트 테이블 조회시 한줄평
    private String imgUrl;      //개인 포토 테이블 조회시 이미지 url
    private String location;    //개인 포스트 장소

    //위 개인, 아래 파트너

    private String storeName;    //파트너 테이블 조회시 postTitle역할
    private String signatureMenu; //파트너 테이블 조회시 한줄평 대신
    private String storeImage; // 파트너 테이블 조회시 이미지
    private String store_location; // 파트너 테이블 조회시 장소

    //individualPost 조회할 필드
//    public SearchPreviewDTO(IndividualMem individualMem, IndividualPost individualPost) {
//        this.pageName = individualMem.getPageName();
//        this.characterName = individualMem.getCharacterName();
//        this.postTitle = individualPost.getPostTitle();
//        this.postReview = individualPost.getPostReview();
//    } 위의 생성자를 아래의 생성자로 대체, 그리고 어노테이션QueryProjection 추가
    @QueryProjection
    public SearchPreviewDTO(String postTitle,String characterName,
                            String postReview, String imgUrl, String location) {
        this.postTitle = postTitle;
        this.characterName = characterName;
        this.postReview = postReview;
        this.imgUrl = imgUrl;
        this.location = location;
    }

    //PartnerMem 조회할 필드
//    public SearchPreviewDTO(PartnerMem partnerMem, PartnerMemPK partnerMemPK) {
//        this.storeName = partnerMem.getStoreName();
//        this.location = partnerMemPK.getStore_location();
//    } 위의 생성자를 아래의 생성자로 대체
    @QueryProjection
    public SearchPreviewDTO(String storeName, String signatureMenu,
                            String storeImage, String store_location) {
        this.storeName = storeName;
        this.signatureMenu = signatureMenu;
        this.storeImage = storeImage;
        this.store_location = store_location;
    }
//아래는 필요 없으니 지울것
    @QueryProjection
    public SearchPreviewDTO(Long id, String storeName, String postTitle,
                            String postReview, String imgUrl, String pageName,
                            String characterName) {
//        this.id = id;
        this.storeName = storeName;
        this.postTitle = postTitle;
        this.postReview = postReview;
        this.imgUrl = imgUrl;

//        this.pageName = pageName;
        this.characterName = characterName;
    }



}
