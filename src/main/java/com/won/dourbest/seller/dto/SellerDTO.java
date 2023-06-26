package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerDTO {

    private int sellerCode;
    private String accountNumber;
    private String businessLicense;
    private int numberReported;
    private int totalRevenue;
    private String sellerSns;
    private String sellerUrl;
    private String sellerKakao;
    private int memberCode;
    private List<FundingDTO> funding;
}
