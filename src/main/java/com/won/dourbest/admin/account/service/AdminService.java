package com.won.dourbest.admin.account.service;

import com.won.dourbest.admin.account.dto.*;

import java.util.List;
import java.util.Map;


public interface AdminService {


    /* 해당 게시글 전체 갯수 조회용 메소드 */
    public int selectTotalCount(Map<String, String> searchMap);

    // 모든 회원 목록 조회
    public List<AccountDTO> selectAllaccountList();
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
}
