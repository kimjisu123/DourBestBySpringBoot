package com.won.dourbest.user.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {

    private int paymentCode;
    private String cardCompany;
    private int cardNumber;
    private OrderDTO orderCode;

    // 권한 코드
    private List<CreditListDTO> creditList;


}
