package com.won.dourbest.user.service;

import com.won.dourbest.common.exception.member.MemberModifyException;
import com.won.dourbest.common.exception.member.MemberRegistException;
import com.won.dourbest.common.exception.member.MemberRemoveException;
import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

public interface MemberService {

    // 회원 조회용 메소드

    /*회원 가입용 메소드*/
    int registMember(Map<String, Object> map);

    //맵 객체를 만들어서 넘겨준다.

//    // 회원 정보 수정용 메소드
//    public void modifiyMember(MemberDTO member);
//
//   //회원 탈퇴용 메소드
//   public void removeMember(MemberDTO member) ;

}
