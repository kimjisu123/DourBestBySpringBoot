package com.won.dourbest.user.mypage.service;

import com.won.dourbest.user.mypage.repository.MypageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MypageServiceImpleTest {

    @Autowired private MypageMapper mypageMapper;

    @Test
    void myPageinfo() {
    }

    @Test
    void allCoupon() {
    }

    @Test
    void adminInquire() {
    }

    @Test
    void sellerInquire() {
    }

    @Test
    void reportList() {
    }

    @Test
    void listTotalCount() {
    }

    @Test
    void couponRegister() {

        int i = mypageMapper.updateCouponStatus(44);
        System.out.println("i = " + i);


    }
}