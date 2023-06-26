package com.won.dourbest.admin.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDTO {

    private int reportResponseCode;
    private String answersContent;
    private Date answerDate;
    private char answersStatus;
    private AdminDTO adminCode;
    private FundingReportDTO reportCode;

}
