package com.culfoshe.main.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Paging {

    private int maxPage;
    private int start;
    private int end;
    private int nowPage;

    public Paging withMaxPage(int maxPage, int totalPage, int nowPage){
        this.nowPage = nowPage;
        this.maxPage = maxPage;
        this.start = ((nowPage-1)/5)*maxPage + 1;
        this.end = totalPage > start + maxPage -1 ? start + maxPage - 1 : totalPage;
        return this;
    }

}
