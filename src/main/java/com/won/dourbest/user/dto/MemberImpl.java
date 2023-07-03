package com.won.dourbest.user.dto;

import com.won.dourbest.common.dto.MemberShipDTO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
public class MemberImpl extends User {

    private int memberCode;  // 멤버코드
    private String memberId;  // 아이디
    private String password;  // 비번
    private String memberName; // 이름
    private String memberPhone; // 전화번호
    private String memberEmail; // 이메일
    private Date registDate;  //가입일
    private char withdrawalStatus;  //탈퇴여부
    private char adultStatus; // 성인여부
    private MemberShipDTO membership;  //멤버쉽

    private List<MemberAuthListDTO> memberRoleList; // 권한
    public MemberImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setDetail(MemberDTO member){
        this.memberCode = member.getMemberCode();
        this.memberId = member.getMemberId();
        this.password = member.getMemberPwd();
        this.memberName = member.getMemberName();
        this.memberPhone = member.getMemberPhone();
        this.memberEmail = member.getMemberEmail();
        this.registDate = member.getRegistDate();
        this.withdrawalStatus = member.getWithdrawalStatus();
        this.adultStatus = member.getAdultStatus();
        this.membership = member.getMembership();
        this.memberRoleList = member.getMemberAuthList();

    }


}
