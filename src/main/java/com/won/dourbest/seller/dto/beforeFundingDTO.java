package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class beforeFundingDTO {
    private String fileModificationName;
    private int fundingCode;
    private int amount;
}
