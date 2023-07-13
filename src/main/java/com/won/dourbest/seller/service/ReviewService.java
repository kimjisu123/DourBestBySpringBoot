package com.won.dourbest.seller.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.ReviewDTO;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<ReviewDTO> selectReview(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);
}
