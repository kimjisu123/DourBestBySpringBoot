package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundPageDTO {
    private String fundingTitle;
    private String fundingSummary;
    private String fundingContents;
    private Date endDate;
    private int fundingGoalMoney;
    private String categoryName;
    private int buyNumber;
    private int totalRev;
}
