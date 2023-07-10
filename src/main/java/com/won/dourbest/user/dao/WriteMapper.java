package com.won.dourbest.user.dao;

import com.won.dourbest.seller.dto.ReviewDTO;
import com.won.dourbest.seller.dto.ReviewFileDTO;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WriteMapper {

  int insertReview(ReviewDTO review);

  int insertReviewFile(ReviewFileDTO reviewFile);

  int contactCount(@Param("userId")String userId, @Param("fundingCode") int fundingCode, @Param("categoryCode") int categoryCode);

  int insertSellerInquire(SellerInquiryDTO inquiry);

  ReviewDTO reviewList(int reviewCode);
}
