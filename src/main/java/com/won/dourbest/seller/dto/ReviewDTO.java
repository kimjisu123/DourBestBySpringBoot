package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {

    private int reviewCode;
    private String reviewTitle;
    private String reviewContent;
    private Date creationDate;
    private char answerStatus;
    private FundingDTO funding;
    private MemberDTO member;

    // 후기 파일 리스트
    private List<ReviewFileDTO> reviewFileList;
}
