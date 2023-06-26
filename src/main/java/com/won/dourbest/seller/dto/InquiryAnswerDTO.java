package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InquiryAnswerDTO {

    private int inquiryAnswerCode;
    private String inquiryAnswerContent;
    private java.util.Date inquiryAnswerDate;
    private SellerInquiryDTO sellerInquiry;
}
