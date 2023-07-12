package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreditDTO {

    private int rowNum;
    private int orderPrice;
    private int couponListCode;
    private int deliveryCharge;
    private int paymentCode;
    private String carCompany;
    private int cardNumber;
    private int totalPrice;
    private int pointAmount;
    private String creditStatus;
    private Date creditDate;
    private String deliveryStatus;
    private Date deliveryDate;
    private int deliveryNumber;
    private String memberName;
    private int memberPhone;
    private int memberCode;
    private String BaseAddress;
    private String detailAddress;
    private int zipCode;


}
