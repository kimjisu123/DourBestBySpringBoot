package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingFileDTO {

    private int fundingFileCode;
    private String fileOriginalName;
    private String fileModificationName;
    private Date uploadDate;
    private String fileType;
    private char deletionStatus;
    private FundingDTO funding;
}