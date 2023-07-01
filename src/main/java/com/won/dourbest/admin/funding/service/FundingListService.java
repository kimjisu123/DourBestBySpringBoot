package com.won.dourbest.admin.funding.service;

import com.won.dourbest.admin.funding.dto.AdminFundingDTO;

import java.util.List;

public interface FundingListService {

    // 오픈 예정 펀딩 목록
    List<AdminFundingDTO> selectAllWillopen();
    // 진행중인 펀딩 목록
    List<AdminFundingDTO> selectAllOngoing();
    // 완료된 펀딩 목록
    List<AdminFundingDTO> selectAllFinished();

    // 승인된 펀딩 목록
    List<AdminFundingDTO> selectAllapproved();

    List<AdminFundingDTO> selectAllApplied();

    List<AdminFundingDTO> selectAllSellerRegiList();

//    // 신청한 펀딩 목록
//
//    // 판매자 신청 목록
}
