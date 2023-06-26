package com.won.dourbest.user.member.dto;


import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryListDTO {

    private int deliveryListCode;  // 배송내역 코드
    private String deliveryStatus; // 배송상태
    private Date deliveryDate; //  배송날짜
    private int deliveryCode;  //배송코드(FK) > DeliveryDTO

}
