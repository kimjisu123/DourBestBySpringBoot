package com.won.dourbest.user.dto;

import com.won.dourbest.seller.dto.FundingDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PurchasedFundingListDTO {

    private int fundingCode;
    private int memberCode;

    private FundingDTO funding;
}
