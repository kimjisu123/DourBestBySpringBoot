package com.won.dourbest.admin.account.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MembershipPaymentDTO {


    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String membershipStatus;
    private Date paymentDate;
}
