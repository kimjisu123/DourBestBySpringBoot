package com.won.dourbest.seller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {

    private String optionName;
    private int optionPrice;
    private String fileModificationName;
    private int couponDisCount;
    private int pointTotalAmount;
    private int point;
    private int usePoint;
    private int totalPrice;
}
