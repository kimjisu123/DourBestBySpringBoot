package com.won.dourbest.admin.statistics.service;

import com.won.dourbest.admin.account.dto.withdrawnMemberDTO;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.statistics.dto.StatiDTO;

import java.util.List;
import java.util.Map;

public interface StatiService {

    List<StatiDTO> selectAllPrice(SelectCriteria selectCriteria);

    List<StatiDTO> selectAllViews(SelectCriteria selectCriteria);

    List<StatiDTO> selectAllLikes(SelectCriteria selectCriteria);

    List<StatiDTO> selectMonthPrice(SelectCriteria selectCriteria);

    List<StatiDTO> selectMonthViews(SelectCriteria selectCriteria);

    List<StatiDTO> selectMonthLikes(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);
}
