package com.won.dourbest.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Criteria {

    private int page; // 현재 페이지
    private int pageSize; // 한 페이지에 보일 목록 수
    private int rowStart; // 현재페이지에서 시작하는 글의 번호
    private int rowEnd; //현재 페이지에서 끝나는 글의 번호

    public Criteria() {
        this(1,10); // 기본으로 정의
    }

    public Criteria(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0 || pageSize > 100) {
            this.pageSize = 10;
            return;
        }
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getRowStart() {
        rowStart = ((page - 1) * pageSize) + 1;
        return rowStart;
    }

    public int getRowEnd() {
        rowEnd = rowStart + pageSize - 1;
        return rowEnd;
    }


}