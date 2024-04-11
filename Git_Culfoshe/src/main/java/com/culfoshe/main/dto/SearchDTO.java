package com.culfoshe.main.dto;

import com.culfoshe.constant.HeaderCategory;
import groovy.transform.Sealed;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SearchDTO {

    private String searchDateType;  //등록일을 비교해서 조회
    private HeaderCategory headerCategory;  //(헤더)카테고리
    private String searchBy;    //조회 유형
    private String searchQuery="";  //검색어 저장

}
