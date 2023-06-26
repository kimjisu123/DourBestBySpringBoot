package com.won.dourbest.user.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PurchasedFundingListDTO {

    private int memberCode;
    private int fundingCode;
}
