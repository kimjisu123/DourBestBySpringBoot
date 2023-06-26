package com.won.dourbest.user.signup.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class MemberMapper {

//    회원 아이디 선택
    String selectMemberById(String memberId);

//    멤버추가
    int insertMember(MemberDTO member);

//    비밀번호 변경
    String selectEncryptedPwd(MemberDTO member);

//    회원 선택

    MemberDTO selectMember(MemberDTO member);

//    회원 찾기
    MemberDTO findByMemberId(String memberId);

//    회원 변경
    int updateMember(MemberDTO member);

//    회원 삭제
    int deleteMember(MemberDTO member);
}
