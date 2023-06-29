package com.won.dourbest.user.dao;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {

//    // 회원코드 선택하기
//        String selectMemberById(String memberId);

    // 회원 입력 값 집어넣기
        int registMember(Map<String, Object> map);
        int registAddress(Map<String, Object> map);
//
////     비밀번호 암호화
//    String selectEncryptedPwd(MemberDTO member);
//
//    MemberDTO selectMember(MemberDTO member);
//
//    MemberDTO findByMemberId(String memberId);
//
//    int updateMember(MemberDTO member);
//
//    int deleteMember(MemberDTO member);

}
