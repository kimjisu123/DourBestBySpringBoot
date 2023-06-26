package com.won.dourbest.seller.dto;

import com.won.dourbest.common.dto.CategoryDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingReportDTO {

    private int reportCode;
    private String reportContent;
    private Date reportDate;
    private FundingDTO funding;
    private int memberCode;
    private int categoryCode;
}
