package com.won.dourbest.user.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberCouponListDTO extends MypageMainDTO{

    List<CouponListDTO> couponList;
}
