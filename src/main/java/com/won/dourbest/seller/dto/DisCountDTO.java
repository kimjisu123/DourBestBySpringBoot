package com.won.dourbest.seller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DisCountDTO {

    private int fundingCode;
    private int disCount;
    private int usePoint;
}
