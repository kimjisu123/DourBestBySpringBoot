package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingOptionDTO {

    private int fundingOptionCode;
    private String optionName;
    private String optionContents;
    private int optionPrice;
    private int limitQuantity;
    private int fundingCode;
    private String optionSize;
    private String optionColor;
    private Date deliverDate;
    private int currKey;

}
