package com.won.dourbest.user.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CouponListDTO {

    private int mCode;
    private String cp;
    private int couponlistCode; // 쿠폰코드
    private int serialNumber; // 일련번호
    private Date regiDate; // 등록날짜
    private Date validDate; // 유효날짜
    private char couponRegiStatus; //등록 여부
    private char couponUseStatus; // 사용여부
    private CouponDTO coupon; // 쿠폰 코드(FK)


}
