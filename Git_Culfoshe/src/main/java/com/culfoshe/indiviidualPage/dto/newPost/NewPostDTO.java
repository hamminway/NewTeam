package com.culfoshe.indiviidualPage.dto.newPost;

import com.culfoshe.constant.HeaderCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;

@Getter @Setter @ToString
public class NewPostDTO { // 글 등록을 위한 DTO, @PostMapping newPost에서 사용

    private HeaderCategory postCategory;
    private String menuCategory;
    private String postTitle;
    private String postComment;
    @Lob
    private String postReview;
}
