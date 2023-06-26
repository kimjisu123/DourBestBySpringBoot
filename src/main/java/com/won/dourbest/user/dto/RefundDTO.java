package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RefundDTO {

    private int refundCode;
    private char approvalStatus;
    private String refundReason;
    private Date refundDate;
    private CreditDTO paymentCode;

}
