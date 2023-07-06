package com.won.dourbest.admin.statistics.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.statistics.dto.StatiDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatiMapper {

    // 총 금액 순으로 조회
    List<StatiDTO> selectAllPrice(SelectCriteria selectCriteria);

    // 총 조회수 순으로 조회
    List<StatiDTO> selectAllViews(SelectCriteria selectCriteria);

    // 총 좋아요 순으로 조회
    List<StatiDTO> selectAllLikes(SelectCriteria selectCriteria);

    // 월 기준 금액순으로 조회
    List<StatiDTO> selectMonthPrice(SelectCriteria selectCriteria);

    // 월 기준 조회수 순으로 조회
    List<StatiDTO> selectMonthViews(SelectCriteria selectCriteria);

    // 월 기준 좋아요 순으로 조회
    List<StatiDTO> selectMonthLikes(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);
}
