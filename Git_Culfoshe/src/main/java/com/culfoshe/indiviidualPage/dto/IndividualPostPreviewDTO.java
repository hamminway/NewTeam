package com.culfoshe.indiviidualPage.dto;

import com.culfoshe.constant.HeaderCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class IndividualPostPreviewDTO {

    private Long postCode;
    private String postTitle;

    private HeaderCategory postCategory;

    private String postComment;

    private List<String> imgUrlList;

    // IndividualPhoto에 존재하는 이미지들 중 첫번째 이미지를 대표이미지로 쓸 예정임.
    // String으로 그 값을 담을 필드로 imgUrl(아래 필드)를 만듦. 이름은 entity 내 필드와 맞춰줌.
    // 위의 말처럼 값을 담아 IndividualPostCustomImpl에서 사용하기 위해 만들어줌.
    private String imgUrl;

    @QueryProjection
    public IndividualPostPreviewDTO(Long postCode, String postTitle, HeaderCategory postCategory,
                                    String postComment){
        this.postCode = postCode;
        this.postTitle = postTitle;
        this.postCategory = postCategory;
        this.postComment = postComment;
    }

    @QueryProjection
    public IndividualPostPreviewDTO(Long postCode, String postTitle, HeaderCategory postCategory,
                                    String postComment, String imgUrl){
        this.postCode = postCode;
        this.postTitle = postTitle;
        this.postCategory = postCategory;
        this.postComment = postComment;
        this.imgUrl = imgUrl;
    }
}
