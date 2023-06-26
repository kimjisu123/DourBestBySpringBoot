package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDTO {

    private int membershipCode;
    private String membershipName;
    private int accrualRate;
    private String membershipContent;
}
