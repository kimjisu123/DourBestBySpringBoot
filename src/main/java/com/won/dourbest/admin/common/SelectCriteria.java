package com.won.dourbest.admin.common;


import lombok.*;

@Getter
@Setter
public class SelectCriteria {
    private int pageNo;
    private int totalCount;
    private int limit;
    private int buttonAmount;
    private int maxPage;
    private int startPage;
    private int endPage;
    private int startRow;
    private int endRow;
    private String searchValue;            // 검색할 아이디 ( 조건 )


    public SelectCriteria() {
    }


    public SelectCriteria(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage, int endPage, int startRow, int endRow, String searchValue) {
        super();
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.limit = limit;
        this.buttonAmount = buttonAmount;
        this.maxPage = maxPage;
        this.startPage = startPage;
        this.endPage = endPage;
        this.startRow = startRow;
        this.endRow = endRow;
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return "SelectCriteria{" +
                "pageNo=" + pageNo +
                ", totalCount=" + totalCount +
                ", limit=" + limit +
                ", buttonAmount=" + buttonAmount +
                ", maxPage=" + maxPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", searchValue='" + searchValue + "\'" +
                '}';
    }
}