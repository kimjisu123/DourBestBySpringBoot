package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PointListDTO {

    private Date pointDate;
    private String pointStatus;
    private int pointAmount;
    private int pointTotalAmount;
    private int pointCode;
    private MemberDTO memberCode;

}
