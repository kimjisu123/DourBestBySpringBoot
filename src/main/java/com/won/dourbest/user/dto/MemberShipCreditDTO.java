package com.won.dourbest.user.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberShipCreditDTO {

    private int membershipCreditCode; // 멤버십결제
    private int memberCode; //회원코드
    private String cardCompany; // 카드사
    private String cardNumber; // 카드번호

    private List<MemberShipCreditListDTO> shipCreditList;
}
