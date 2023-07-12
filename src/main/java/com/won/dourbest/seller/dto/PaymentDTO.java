package com.won.dourbest.seller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentDTO {

    private String bankName;
    private String totalPrice;
    private String bankNum;
    private String orderCode;
}
