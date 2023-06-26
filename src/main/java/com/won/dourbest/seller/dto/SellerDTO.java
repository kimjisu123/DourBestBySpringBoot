package com.won.dourbest.seller.dto;

import com.won.dourbest.user.dto.MemberDTO;
import lombok.*;

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

    private MemberDTO member;
}
