package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

public class MemberDTO {

    private int memberCode;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private Date registDate;
    private char withdrawalStatus;
    private char adultStatus;
    private MembershipDTO membershipCode;

}