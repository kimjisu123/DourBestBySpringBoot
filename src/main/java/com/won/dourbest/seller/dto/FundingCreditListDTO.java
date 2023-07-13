package com.won.dourbest.seller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FundingCreditListDTO {

    private int fundCreditCode;
    private String creditStatus;
    private String creditDate;
    private int paymentCode;
}
