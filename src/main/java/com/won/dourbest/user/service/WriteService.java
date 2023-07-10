package com.won.dourbest.user.service;

import com.won.dourbest.seller.dto.ReviewDTO;
import com.won.dourbest.seller.dto.ReviewFileDTO;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import org.apache.ibatis.annotations.Param;

public interface WriteService {

  int saveReview(ReviewDTO review);

  int saveReviewFile(ReviewFileDTO reviewFile);

  int contactCount(String userId,int fundingCode,int categoryCode);

  int saveSellerInquire(SellerInquiryDTO sellerInquiry);

  ReviewDTO reviewList(int reviewCode);

}
