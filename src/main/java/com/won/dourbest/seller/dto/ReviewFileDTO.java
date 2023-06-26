package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewFileDTO {

    private int reviewFileCode;
    private String fileOriginalName;
    private String fileModificationName;
    private java.util.Date uploadDate;
    private char deletionStatus;
    private ReviewDTO review;
}
