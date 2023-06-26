package com.won.dourbest.seller.dto;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.user.dto.MemberDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingReportDTO {

    private int reportCode;
    private String reportContent;
    private java.util.Date reportDate;
    private List<FundingDTO> funding;
    private List<MemberDTO> member;
    private CategoryDTO category;
}
