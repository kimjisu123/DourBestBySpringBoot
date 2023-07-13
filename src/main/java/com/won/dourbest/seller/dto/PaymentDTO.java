package com.won.dourbest.seller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentDTO {

    private String bankName;
    private int totalPrice;
    private int bankNum;
    private int orderCode;
    private int paymentCode;
}
