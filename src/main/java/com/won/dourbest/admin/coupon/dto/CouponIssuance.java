package com.won.dourbest.admin.coupon.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CouponIssuance {

    private String memberId;
    private String memberName;
    private String memberEmail;
    private String couponName;
    private String couponDiscount;
    private Date couponValidDate;
}
