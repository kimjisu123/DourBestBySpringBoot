package com.won.dourbest.seller.dto;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.user.dto.MemberDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerInquiryDTO {

    private int sellerInquiryCode;
    private String inquiryTitle;
    private String inquiryContent;
    private java.util.Date inquiryDate;
    private char answerStatus;
    private List<FundingDTO> funding;
    private List<MemberDTO> member;
    private CategoryDTO category;
}
