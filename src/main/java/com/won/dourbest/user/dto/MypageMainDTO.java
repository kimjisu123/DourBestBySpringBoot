package com.won.dourbest.user.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MypageMainDTO {

    private String memberId;
    private String memberName;
    private String membershipName;
    private int couponCount;
    private int pointTotalAmount;

    private String profile;

}
