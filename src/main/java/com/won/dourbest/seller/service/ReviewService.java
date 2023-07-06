package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> selectReview();
}
