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

    @QueryProjection
    public IndividualPostPreviewDTO(Long postCode, String postTitle, HeaderCategory postCategory,
                                    String postComment){
        this.postCode = postCode;
        this.postTitle = postTitle;
        this.postCategory = postCategory;
        this.postComment = postComment;
    }
}
