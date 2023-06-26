package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingNoticeDTO {

    private int fundingNoticeCode;
    private String noticeTitle;
    private java.util.Date noticeDate;
    private String noticeContent;
    private List<FundingDTO> funding;
}
