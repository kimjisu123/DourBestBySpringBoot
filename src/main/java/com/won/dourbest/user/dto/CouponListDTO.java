package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CouponListDTO {

    private int couponlistCode;
    private int serialNumber;
    private Date regiDate;
    private Date validDate;
    private char couponRegiStatus;
    private char couponUseStatus;
    private CouponDTO couponCode;
    private MemberDTO memberCode;
}
