package com.won.dourbest.user.dto;


import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberShipCreditDTO {

    private int membershipCreditCode; // 멤버십결제
    private int memberCode; //회원코드
    private String cardCompany; // 결제사
    private String paymentNumber; // 결제번호
    private Date paymentDate; //결제날짜
    private String memberStatus; //결제상태

}
