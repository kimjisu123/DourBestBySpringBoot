package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderFundingDTO {

    private int rowNum;
    private int orderCode;
    private String fundingTitle;
    private int fundingCode;
    private String fundingSummary;
    private String optionName;
    private Date changeDate;
    private String fundingStatusName;
    private String filePath;
}
