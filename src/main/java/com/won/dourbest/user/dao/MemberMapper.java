package com.won.dourbest.user.dao;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.CheckMemberDTO;
import com.won.dourbest.user.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.Optional;

@Mapper
public interface MemberMapper {


    // 회원 입력 값 집어넣기
    int registMember(Map<String, Object> map);

    int registAddress(Map<String, Object> map);

    // 아이디체크 (회원가입시)
    int idCheck(String memberId);

    //이메일체크 (회원가입시)
    int emailCheck(String memberEmail);   // 중복이 없으면 0 있으면 1 반환

    // 멤버 권한 설정
    int insertMemberAuth();

    //회원 정보 찾기
    Optional<MemberDTO> findByMember(String userId);

    //이메일로 비밀번호 찾기
    int updatePwd(CheckMemberDTO checkMember);

    //이메일 찾기
    Optional<String> findByEmail(String memberEmail);

    //회원 정보수정( memberDTO)
    int updateMember(Map<String, Object> map);

    //회원 정보수정(addressDTO)
    int updateAddress(Map<String, Object> map);

    // 회원 비밀번호 변경
    int changePwd(MemberDTO member);

    int deleteMember(String memberId);

}
