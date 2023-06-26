package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingNoticeDTO {

    private int fundingNoticeCode;
    private String noticeTitle;
    private Date noticeDate;
    private String noticeContent;
    private FundingDTO funding;
}
