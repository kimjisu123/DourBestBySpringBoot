package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewAnswersDTO {

    private int reviewAnswerCode;
    private String reviewsAnswerContent;
    private java.util.Date reviewDate;
    private ReviewDTO review;
}
