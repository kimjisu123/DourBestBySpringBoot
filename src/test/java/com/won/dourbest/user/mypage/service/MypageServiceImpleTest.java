package com.won.dourbest.user.mypage.service;

import com.won.dourbest.user.dto.MypageDTO;
import com.won.dourbest.user.dto.MypageMainDTO;
import com.won.dourbest.user.mypage.repository.MypageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MypageServiceImpleTest {

    @Autowired MypageService mypageService;

    @Test
    void myPageinfo() {
        Map<String, Object> testuser = mypageService.myPageinfo("testuser");
        System.out.println("testuser = " + testuser.get("mypageMain"));
        System.out.println("delivery = " + testuser.get("delivery"));

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




    }
}