package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreditListDTO {

    private int fundCreditCode;
    private char creditStatus;
    private Date creditDate;
    private int paymentCode;


}
