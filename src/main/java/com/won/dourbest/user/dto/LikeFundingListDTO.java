package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LikeFundingDTO {


    private int fundingCode;
    private int memberCode;

    private FundingDTO funding;
}
