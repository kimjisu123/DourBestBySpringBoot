package com.won.dourbest.user.dto;

import com.won.dourbest.seller.dto.FundingDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LikeFundingListDTO {

    private List<FundingDTO> funding;
    private List<MemberDTO> member;
}
