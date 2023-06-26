package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberShipCreditListDTO {

    private int memberCreditCode;
    private Date paymentDate;
    private int memberShipCredit;
    private String membershipStatus;
}
