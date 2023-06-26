package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponseDTO {

    private int ReportResponseCode;
    private String answersContent;
    private Date answerDate;
    private char answersStatus;
    private int adminCode;
    private int reportCode;

}
