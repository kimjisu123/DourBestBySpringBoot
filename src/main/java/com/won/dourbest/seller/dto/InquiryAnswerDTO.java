package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InquiryAnswerDTO {

    private int inquiryAnswerCode;
    private String inquiryAnswerContent;
    private Date inquiryAnswerDate;
    private SellerInquiryDTO sellerInquiry;
}
