package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {

    private int deliveryCode;
    private int deliveryNumber;
    private String deliveryCompany;
    private int deliveryCharge;
    private CreditDTO paymentCode;

}
