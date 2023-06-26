package com.won.dourbest.user.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CouponDTO {

    private int couponCode; // 쿠폰코드
    private String couponName; // 쿠폰명
    private String couponContent; // 내용
    private int couponDiscount; // 할인
    private Date couponValidDate; //유효기간

}
