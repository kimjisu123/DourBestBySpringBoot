package com.won.dourbest.seller.dao.jiho;

import com.won.dourbest.seller.dto.PlanDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerMapper {
    // 플랜 조회
    List<PlanDTO> allPlan();

    // 태그 select
    int selectTag(String tag);

    // 태그 insert
    int insertTag(String tag);

}
