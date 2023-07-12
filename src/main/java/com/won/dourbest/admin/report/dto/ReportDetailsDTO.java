package com.won.dourbest.admin.report.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportDetailsDTO {

    private String memberId;
    private String memberEmail;
    private String fundingTitle;
    private String reportTitle;
    private Date report_date;
    private int numberReported;
    private String answersStatus;
    private int fundingCode;
}
