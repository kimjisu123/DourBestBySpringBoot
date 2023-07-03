package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.PlanDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface SubmitService {

    // 모든 요금제 조회
    List<PlanDTO> allPlan();

    // 태그 Insert
    int insertTag(String[] sarr);

    // 펀딩 카테고리 조회
    List<CategoryDTO> getFundCategory();

    // 펀딩과 펀딩자료 Insert
    Map<String, Integer> insertAboutFunding(Map<String, Object> tossMap);

    // 옵션 Insert
    int insertOption(FundingOptionDTO option);
}
