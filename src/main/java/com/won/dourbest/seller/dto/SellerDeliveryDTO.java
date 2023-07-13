package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerDeliveryDTO {

    private int deliveryCode;  // 배송코드
    private Long deliveryNumber;  // 운송장번호
    private String deliveryCompany; // 배송업체
    private int deliveryCharge; //배송비
    private int paymentCode;
}
