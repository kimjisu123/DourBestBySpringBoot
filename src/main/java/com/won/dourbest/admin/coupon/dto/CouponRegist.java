package com.won.dourbest.admin.coupon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CouponRegist {
    private String couponName;
    private String couponContent;
    private int couponDiscount;
    private Date couponVaildDate;
}
