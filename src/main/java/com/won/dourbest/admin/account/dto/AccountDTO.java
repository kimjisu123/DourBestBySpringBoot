package com.won.dourbest.admin.account.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private int memberCode;  // 멤버코드
    private String memberId;  // 아이디
    private String memberPwd;  // 비번
    private String memberName; // 이름
    private String memberPhone; // 전화번호
    private String memberEmail; // 이메일
    private Date registDate;  //가입일
    private char withdrawalStatus;  //탈퇴여부
    private char adultStatus; // 성인여부
    private String sellerCode; // 판매자 코드
}
