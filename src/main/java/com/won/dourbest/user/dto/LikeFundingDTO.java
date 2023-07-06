package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LikeFundingDTO {

    private int rowNum;

    private int fundingCode;

    private String fundingTitle;

    private String fundingSummary;

    private String categoryName;

    private String filePath;

    private Date startDate;

    private Date endDate;




}
