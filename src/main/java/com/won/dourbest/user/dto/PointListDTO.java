package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

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
    private int memberCode;

    //

}
