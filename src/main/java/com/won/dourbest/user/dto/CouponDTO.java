package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {

    private int couponCode;
    private String couponName;
    private String couponContent;
    private int couponDiscount;
    private Date couponValidDate;
}
