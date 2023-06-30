package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberCouponList {

    private int rowNum;

    private int couponListCode;

    private int couponCode;

    private String useStatus;

    private String regiStatus;

    private Date validDate;

    private CouponDTO coupon;

}
