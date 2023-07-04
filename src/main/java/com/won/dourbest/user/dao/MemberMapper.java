package com.won.dourbest.user.dao;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
import com.won.dourbest.user.dto.MemberDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Optional;

@Mapper
public interface MemberMapper {

//    // 회원코드 선택하기
//        String selectMemberById(String memberId);

    // 회원 입력 값 집어넣기
        int registMember(Map<String, Object> map);
        int registAddress(Map<String, Object> map);
//
        int idCheck(String memberId);  // 아이디 찾기

        int emailCheck(String memberEmail);   // 중복이 없으면 0 있으면 1 반환

//멤버 정보 가지고 오기
    MemberDTO selectMember(String memberId);
//
    int insertMemberAuth();

    Optional<MemberDTO> findByMember(String userId);    //로그인
//
    int updateMember(Map<String, Object> map);

    int updateAddress(Map<String, Object> map);
//
//    int deleteMember(MemberDTO member);

}
