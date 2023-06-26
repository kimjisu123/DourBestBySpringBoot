package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FundingFileDTO {

    private int fundingFileCode;
    private String fileOriginalName;
    private String fileModificationName;
    private java.util.Date uploadDate;
    private char fileType;
    private String deletionStatus;
    private List<FundingDTO> funding;
}
