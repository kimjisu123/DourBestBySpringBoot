package com.won.dourbest.user.member.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDTO {

    private int deliveryCode;  // 배송코드
    private int deliveryNumber;  // 운송장번호
    private String deliveryCompany; // 배송업체
    private int deliveryCharge; //배송비

    private int creditCode; // 결제코드 (FK) 1:1 관계


}
