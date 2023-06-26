package com.won.dourbest.admin.dto;


import com.won.dourbest.seller.dto.SellerDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InquiryAnswerDTO {

    private int inquiryAnswerCode;
    private String inquiryAnswerContent;
    private Date inquiryAnswerDate;
    private SellerDTO SellerInquiryCode;

}
