package com.won.dourbest.common.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberShipDTO {

    private int membershipCode;
    private String membershipName;
    private int accrualRate;
    private String membershipContent;

}
