package com.won.dourbest.seller.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {

    private int reviewCode;
    private String memberId;
    private String reviewTitle;
    private String reviewContent;
    @Nullable
    private String creationDate;
    private String answerStatus;
    private int reviewStar;
    private int memberCode;
    private int fundingCode;
    @Nullable
    List<ReviewFileDTO> reviewFile;
}
