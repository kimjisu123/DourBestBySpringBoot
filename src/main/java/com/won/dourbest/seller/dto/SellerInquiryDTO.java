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
    private int fundingCode;
    private int memberCode;
    private int categoryCode;

    private String answerContent;
    private Date answerDate;

    private String fundingTitle;

}
