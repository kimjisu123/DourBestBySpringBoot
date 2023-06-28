package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dto.PlanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SubmitService {

    // 모든 요금제 조회
    List<PlanDTO> allPlan();

    // 태그 Insert
    int insertTag(String[] sarr);



}
