package com.won.dourbest.seller.dto;

import com.won.dourbest.user.dto.MemberDTO;
import lombok.*;

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
    private java.util.Date creationDate;
    private char answerStatus;
    private List<FundingDTO> funding;
    private List<MemberDTO> member;
}
