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
    private int price;
    private int fundingCode;
    private int memberCode;
    private String orderRequest;

}
