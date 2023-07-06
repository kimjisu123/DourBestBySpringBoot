package com.won.dourbest.seller.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.QuestionDTO;

import java.util.List;
import java.util.Map;


public interface QuestionService {
    List<QuestionDTO> selectQuestion(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);
}
