package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {

    private String memberId;
    private String reviewTitle;
    private String reviewContent;
    private String creationDate;
}
