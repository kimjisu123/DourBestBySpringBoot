package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingTagDTO {

    private List<TagDTO> tag;
    private List<FundingDTO> funding;
}
