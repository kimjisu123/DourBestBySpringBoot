package com.won.dourbest.admin.funding.dao;

import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFundingMapper {


    // 오픈 예정 펀딩 조회
    List<AdminFundingDTO> selectAllWillopen();
    // 진행중인 펀딩 조회
    List<AdminFundingDTO> selectAllOngoing();


    // 완료된 펀딩 목록
    List<AdminFundingDTO> selectAllFinished();


    // 승인된 펀딩 목록
    List<AdminFundingDTO> selectAllapproved();

    // 신청한 펀딩 목록
    List<AdminFundingDTO> selectAllApplied();

    // 판매자 등록 신청 목록
    List<AdminFundingDTO> selectAllSellerRegiList();
}
