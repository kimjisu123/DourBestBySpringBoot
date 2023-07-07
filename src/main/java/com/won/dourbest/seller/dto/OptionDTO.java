package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OptionDTO {
    private String optionName;
    private String optionContents;
    private int optionPrice;
    private int limitQuantity;
    private String optionColor;
    private String optionSize;
    private String deliverDate;

}
