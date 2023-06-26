package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingTagDTO {

    private TagDTO tag;
    private int fundingCode;

}
