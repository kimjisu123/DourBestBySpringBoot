package com.won.dourbest.admin.funding.service;

import com.won.dourbest.admin.funding.dto.AdminFundingDTO;

import java.util.List;

public interface FundingListService {

    List<AdminFundingDTO> selectAllapproved();

    List<AdminFundingDTO> selectAllWillopen();

    List<AdminFundingDTO> selectAllOngoing();

    List<AdminFundingDTO> selectAllFinished();
}
