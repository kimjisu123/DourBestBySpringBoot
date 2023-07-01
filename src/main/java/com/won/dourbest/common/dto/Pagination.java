package com.won.dourbest.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class Pagination {

    private int startPage; //네비게이션에서의 시작번호
    private int endPage; //네비게이션에서의 끝나는 번호
    private boolean prev;  // 이전 다음링크 표시여부
    private boolean next;
    private int totalPage; // 전체 페이지의 개수
    private int totalCount; // 글의 전체 개수
    private Criteria criteria;

    public void setCri(Criteria criteria) {
        this.criteria = criteria;
    }

    public Pagination(Criteria criteria, int totalCount) {
        this.criteria = criteria;
        this.totalCount = totalCount;

        paging(criteria, totalCount);
    }

    private void paging(Criteria cri, int totalCount){
        this.endPage = (int) (Math.ceil(cri.getPage() / (double)cri.getPageSize())) * cri.getPageSize();
        this.startPage = (endPage - criteria.getPageSize()) + 1;

        this.totalPage = (int) (Math.ceil(totalCount / (double)cri.getPageSize()));

        if (this.endPage > this.totalPage) {
            this.endPage = this.totalPage;
        }

        this.prev = this.startPage != 1;
        this.next = this.endPage != totalPage;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +

                '}';
    }
}