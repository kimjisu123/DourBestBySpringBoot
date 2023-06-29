package com.won.dourbest.admin.funding.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminFundingDTO {

    private String memberId;
    private String memberEmail;
    private String fundingTitle;
    private Date startDate;
    private Date endDate;
}
