package com.won.dourbest.admin.funding.service;

import com.won.dourbest.admin.funding.dao.AdminFundingMapper;
import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundingListServiceImpl implements FundingListService {
    // 매퍼 생성자
    private final AdminFundingMapper mapper;
    public FundingListServiceImpl(AdminFundingMapper mapper) {
        this.mapper = mapper;
    }

    // 오픈 예정 펀딩 조회
    @Override
    public List<AdminFundingDTO> selectAllWillopen() {
        List<AdminFundingDTO> willopenFundingList = mapper.selectAllWillopen();

        return willopenFundingList;
    }

    // 진행중인 펀딩 조회
    @Override
    public List<AdminFundingDTO> selectAllOngoing() {
        List<AdminFundingDTO> ongoingFundingList = mapper. selectAllOngoing();

        return ongoingFundingList;
    }

    // 완료된 펀딩 목록
    @Override
    public List<AdminFundingDTO> selectAllFinished() {
        List<AdminFundingDTO> finishedFundingList = mapper.selectAllFinished();

        return finishedFundingList;
    }

    // 승인된 펀딩 목록
    @Override
    public List<AdminFundingDTO> selectAllapproved() {

        List<AdminFundingDTO> approvedFundingList = mapper.selectAllapproved();

        return approvedFundingList;
    }
    // 신청한 펀딩 목록
    @Override
    public List<AdminFundingDTO> selectAllApplied() {
        List<AdminFundingDTO> fundingAppliedList = mapper.selectAllApplied();

        return fundingAppliedList;
    }

    // 판매자 등록 신청 목록
    @Override
    public List<AdminFundingDTO> selectAllSellerRegiList() {

        List<AdminFundingDTO> sellerRegiList = mapper.selectAllSellerRegiList();

        return sellerRegiList;

    }

}
