package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.ReviewMapper;
import com.won.dourbest.seller.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper mapper;

    public ReviewServiceImpl(ReviewMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<ReviewDTO> selectReview() {

        List<ReviewDTO> review = mapper.selectReview();

        return review;
    }
}
