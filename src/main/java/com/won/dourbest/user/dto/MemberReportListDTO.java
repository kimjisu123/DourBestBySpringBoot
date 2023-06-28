package com.won.dourbest.user.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberReportListDTO {

    private String fundingTitle;
    private Date reportDate;
    private String categoryName;
    private String answerStatus;
}
