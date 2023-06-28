package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.user.dto.*;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MypageMapperTest {

    @Autowired
    private MypageMapper mypageMapper;
    @Test
    void findById() {

        String userId = "user01";

        MypageDTO result = mypageMapper.findById(userId);

        log.info("resul={}", result);

    }

    @Test
    void findByCoupon() {

        String userId = "user02";

        List<CouponListDTO> result = mypageMapper.findByCoupon(userId);
        assertThat(result).isEmpty();
        log.info("resul={}", result);

    }


    @Test
    void likefunding(){
        String userId = "user01";
        List<LikeFundingDTO> result = mypageMapper.findLikeFundingById(userId);

        log.info("resul={}", result);
    }

    @Test
    void findPurchasedFundingById(){
        String userId = "user01";
        List<PurchasedFundingListDTO> result = mypageMapper.findPurchasedFundingById(userId);
        log.info("result={}", result);
    }

    @Test
    void findInquireAllById(){
        String userId = "user02";
        List<MemberInquireListDTO> result = mypageMapper.findInquireAllById(userId);
        log.info("result={}", result);
    }

    @Test
    void findReportAllById(){
        String userId = "user02";
        List<MemberReportListDTO> result = mypageMapper.findReportAllById(userId);
        log.info("result={}", result);
    }

    @Test
    void findSellerInquireById(){
        String userId = "user02";
        List<MemberSellerInquireDTO> result = mypageMapper.findSellerInquireById(userId);
        log.info("result={}", result);
    }





}