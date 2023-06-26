package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingStatuslistDTO {

    private int fundingStatusHistoryCode;
    private java.util.Date changeDate;
    private List<FundingStatusDTO> fundingStatus;
    private List<FundingDTO> funding;
}
