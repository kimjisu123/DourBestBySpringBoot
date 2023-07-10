package com.won.dourbest.user.service;

import com.won.dourbest.seller.dto.ReviewDTO;
import com.won.dourbest.seller.dto.ReviewFileDTO;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import com.won.dourbest.user.dao.WriteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService{

  private final WriteMapper writeMapper;

  @Override
  public int saveReview(ReviewDTO review) {
    return writeMapper.insertReview(review);
  }

  @Override
  public int saveReviewFile(ReviewFileDTO reviewFile) {
    return writeMapper.insertReviewFile(reviewFile);
  }

  @Override
  public int contactCount(String userId, int fundingCode, int categoryCode) {
    return writeMapper.contactCount(userId,fundingCode,categoryCode);
  }

  @Override
  public int saveSellerInquire(SellerInquiryDTO sellerInquiry) {
    return writeMapper.insertSellerInquire(sellerInquiry);
  }

  @Override
  public ReviewDTO reviewList(@RequestParam int reviewCode) {
    return writeMapper.reviewList(reviewCode);
  }
}
