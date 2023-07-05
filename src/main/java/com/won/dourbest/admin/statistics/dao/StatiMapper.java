package com.won.dourbest.admin.statistics.dao;

import com.won.dourbest.admin.statistics.dto.StatiDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatiMapper {

    // 총 금액 순으로 조회
    List<StatiDTO> selectAllPrice();

    // 총 조회수 순으로 조회
    List<StatiDTO> selectAllViews();

    // 총 좋아요 순으로 조회
    List<StatiDTO> selectAllLikes();

    // 월 기준 금액순으로 조회
    List<StatiDTO> selectMonthPrice();

    // 월 기준 조회수 순으로 조회
    List<StatiDTO> selectMonthViews();

    // 월 기준 좋아요 순으로 조회
    List<StatiDTO> selectMonthLikes();
}
