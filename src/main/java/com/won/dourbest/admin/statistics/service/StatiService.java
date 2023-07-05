package com.won.dourbest.admin.statistics.service;

import com.won.dourbest.admin.account.dto.withdrawnMemberDTO;
import com.won.dourbest.admin.statistics.dto.StatiDTO;

import java.util.List;

public interface StatiService {

    List<StatiDTO> selectAllPrice();

    List<StatiDTO> selectAllViews();

    List<StatiDTO> selectAllLikes();

    List<StatiDTO> selectMonthPrice();

    List<StatiDTO> selectMonthViews();

    List<StatiDTO> selectMonthLikes();
}
