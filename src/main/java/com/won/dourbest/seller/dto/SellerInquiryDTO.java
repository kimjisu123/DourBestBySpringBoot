package com.won.dourbest.seller.dto;

import com.won.dourbest.common.dto.CategoryDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerInquiryDTO {

    private int sellerInquiryCode;
    private String inquiryTitle;
    private String inquiryContent;
    private Date inquiryDate;
    private char answerStatus;
    private FundingDTO funding;
    private MemberDTO member;
    private CategoryDTO category;
}
