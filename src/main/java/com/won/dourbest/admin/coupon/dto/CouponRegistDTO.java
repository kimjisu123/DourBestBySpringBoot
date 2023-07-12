package com.won.dourbest.admin.coupon.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CouponRegistDTO {
    private String couponCode;
    private String couponName;
    private String couponContent;
    private int couponDiscount;
    private Date couponVaildDate;
}
