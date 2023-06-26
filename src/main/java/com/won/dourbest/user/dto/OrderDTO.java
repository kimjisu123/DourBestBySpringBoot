package com.won.dourbest.user.dto;

import com.won.dourbest.seller.dto.FundingDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int orderCode;
    private int orderCount;
    private int price;
    private FundingDTO fundingCode;
    private MemberDTO memberCode;
    private String orderRequest;
}
