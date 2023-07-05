package com.won.dourbest.admin.account.dao;

import com.won.dourbest.admin.account.dto.*;
import com.won.dourbest.admin.common.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface AdminMapper {
    // 모든 회원 목록 조회
    public List<AccountDTO> selectAllaccountList(SelectCriteria selectCriteria);

    // 탈퇴한 회원 조회
    List<withdrawnMemberDTO> selectAllwithdrawnList();

    // 펀딩 결제 내역 조회
    List<FundingPaymentDTO> selectAllFunPaymentList();

    // 멤버십 결제 내역 조회
    List<MembershipPaymentDTO> selectAllmemPaymentList();

    // 블랙리스트 조회
    List<BlcaklistDTO> selectallBlackList();

    // 관리자 계정 조회
    List<AdminAccountDTO> selectAllAdminAccount();

    int selectTotalPage(Map<String, String> searchMap);

    // 관리자 회원가입
    int registAdmin(AdminRegistDTO adminRegist);

    // 아이디 중복체크
    String emailRedundancy(AdminRegistDTO adminRegist);


    // 전화번호 중복체크
    String phoneRedundancy(AdminRegistDTO adminRegist);

    Optional<AdminAccountDTO> findByAdmin(String adminId);


}
