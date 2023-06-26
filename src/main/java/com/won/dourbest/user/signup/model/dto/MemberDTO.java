package com.won.dourbest.user.signup.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberDTO {

    private Long memberNo;
    private String memberId;
    private String memberPwd;
    private String Mename;
    private String phone;
    private String email;
    private String address;
    private Date enrollDate;
    private String memberRole;
    private String memberStatus;

}
