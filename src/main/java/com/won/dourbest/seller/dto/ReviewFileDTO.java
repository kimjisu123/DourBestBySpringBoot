package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewFileDTO {

    private int reviewFileCode;
    private String fileOriginalName;
    private String fileModificationName;
    private Date uploadDate;
    private char deletionStatus;
    private ReviewDTO review;
}
