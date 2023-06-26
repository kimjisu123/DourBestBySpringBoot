package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryLIstDTO {

    private int deliveryListCode;
    private char deliveryStatus;
    private Date deliveryDate;
    private DeliveryDTO deliveryCode;

}
