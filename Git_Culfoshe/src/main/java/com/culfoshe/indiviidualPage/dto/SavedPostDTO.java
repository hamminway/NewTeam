package com.culfoshe.indiviidualPage.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class SavedPostDTO {
    private Long postCode;
    private String postTitle;
    private int postViewCount;
    private int postSaveCount;
    private LocalDateTime regTime;
    private String createdBy;
    private String location;

    @QueryProjection
    public SavedPostDTO(Long postCode, String postTitle, int postViewCount, int postSaveCount, LocalDateTime regTime,
                        String createdBy, String location){
        this.postCode = postCode;
        this.postTitle = postTitle;
        this.postViewCount = postViewCount;
        this.postSaveCount = postSaveCount;
        this.regTime = regTime;
        this.createdBy = createdBy;
        this.location = location;

    }
}
