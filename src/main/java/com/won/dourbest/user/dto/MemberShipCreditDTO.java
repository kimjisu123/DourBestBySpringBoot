package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberShipCreditDTO {

    private int memberCreditCode;
    private Date paymentDate;
    private CreditDTO paymentCode;

}
