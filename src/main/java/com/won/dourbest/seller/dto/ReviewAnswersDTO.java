package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewAnswersDTO {

    private int reviewAnswerCode;
    private String reviewsAnswerContent;
    private Date reviewDate;
    private ReviewDTO review;

}
