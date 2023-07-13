package com.won.dourbest.seller.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dao.ReviewMapper;
import com.won.dourbest.seller.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper mapper;

    public ReviewServiceImpl(ReviewMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<ReviewDTO> selectReview(SelectCriteria selectCriteria) {

        List<ReviewDTO> review = mapper.selectReview(selectCriteria);


        return review;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int search = mapper.selectSearch(searchMap);

        return search;
    }
}
