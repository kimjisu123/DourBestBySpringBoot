package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int orderCode;
    private int orderCount;
    private int orderPrice;
    private int fundingCode;
    private int memberCode;
    private String orderRequest;
    private String orderDate;
    private String fundingOptionCode;
    private String deliveryCharge;
    private String couponlistCode;


}
