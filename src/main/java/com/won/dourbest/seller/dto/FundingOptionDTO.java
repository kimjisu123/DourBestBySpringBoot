package com.won.dourbest.seller.dto;

import lombok.*;

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
    private FundingDTO funding;
}
