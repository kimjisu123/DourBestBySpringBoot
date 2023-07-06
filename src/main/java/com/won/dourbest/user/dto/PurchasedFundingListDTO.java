package com.won.dourbest.user.dto;

import com.won.dourbest.seller.dto.FundingDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PurchasedFundingListDTO {

    private int fundingCode;
    private String fundingTitle;
    private String fundingSummary;
    private Date endDate;
    private Integer reviewCode;
    private int orderCode;
    private String mainFile;
    private int rowNum;

}
