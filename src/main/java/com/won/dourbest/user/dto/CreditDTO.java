package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {

    private int paymentCode;
    private String cardCompany;
    private int cardNumber;
    private OrderDTO orderCode;

}
