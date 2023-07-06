package com.won.dourbest.admin.funding.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import com.won.dourbest.admin.funding.dto.AdminSellerRegistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminFundingMapper {


    // 오픈 예정 펀딩 조회
    List<AdminFundingDTO> selectAllWillopen(SelectCriteria selectCriteria);
    // 진행중인 펀딩 조회
    List<AdminFundingDTO> selectAllOngoing(SelectCriteria selectCriteria);


    // 완료된 펀딩 목록
    List<AdminFundingDTO> selectAllFinished(SelectCriteria selectCriteria);


    // 승인된 펀딩 목록
    List<AdminFundingDTO> selectAllapproved(SelectCriteria selectCriteria);

    // 신청한 펀딩 목록
    List<AdminFundingDTO> selectAllApplied(SelectCriteria selectCriteria);

    // 판매자 등록 신청 목록
    List<AdminSellerRegistDTO> selectAllSellerRegiList(SelectCriteria selectCriteria);

    // 총 게시물의 개수
    int selectTotalPage(Map<String, String> searchMap);
}
