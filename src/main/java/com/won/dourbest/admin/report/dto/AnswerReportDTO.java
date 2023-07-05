package com.won.dourbest.admin.report.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnswerReportDTO {

    private String memberId;
    private String memberEmail;
    private String fundingTitle;
    private String answerContent;
    private Date answerDate;
    private int numberReported;
    private String answersStatus;


}
