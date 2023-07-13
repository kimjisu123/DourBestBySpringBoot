package com.won.dourbest.user.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberReportListDTO {

    private int reportCode;
    private int rowNum;
    private Integer responseCode;
    private String fundingTitle;
    private String reportContent;
    private Date reportDate;
    private String categoryName;
    private String answerStatus;
    private String reportAnswer;
    private Date reportAnswerDate;
    private int fundingCode;
    private int memberCode;
}
