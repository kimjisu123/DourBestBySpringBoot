package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCouponListDTO {

    private int memberCode;
    private int couponCode;
    private String couponName;
    private Integer couponListCode;
}
