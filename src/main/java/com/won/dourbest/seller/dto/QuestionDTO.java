package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDTO {

    private String categoryName;
    private String inquiryContent;
    private String inquiryTitle;
    private String MemberName;
    private String inquiryDate;

}
