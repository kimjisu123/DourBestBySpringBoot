package com.won.dourbest.user.dao;

import com.won.dourbest.seller.dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class WriteMapperTest {

  @Autowired WriteMapper writeMapper;
  @Test
  void insertReview() {

    ReviewDTO review = new ReviewDTO(0,"dfdfd", "dfdf","asdfasdf",null,"N",3,53,95,null);

    writeMapper.insertReview(review);


    System.out.println("review.getReviewCode() = " + review.getReviewCode());

    


  }
}