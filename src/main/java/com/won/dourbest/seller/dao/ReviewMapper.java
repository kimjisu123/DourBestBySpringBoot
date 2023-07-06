package com.won.dourbest.seller.dao;


import com.won.dourbest.seller.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> selectReview();
}
