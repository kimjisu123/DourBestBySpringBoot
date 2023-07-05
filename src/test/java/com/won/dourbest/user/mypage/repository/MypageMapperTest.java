package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.common.dto.Pagination;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.*;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MypageMapperTest {

    @Autowired
    private MypageMapper mypageMapper;
    @Test
    void findById() {

        String userId = "testuser";

        MypageDTO result = mypageMapper.findById(userId);

        log.info("resul={}", result);

    }

    @Test
    void findByCoupon() {

        String userId = "user01";
        SearchCriteria criteria = new SearchCriteria();
        System.out.println("criteria = " + criteria);
        System.out.println("criteria.getPage() = " + criteria.getPage());
        System.out.println("criteria.getPageSize() = " + criteria.getPageSize());
        Pagination pagination = new Pagination(criteria,100);
        System.out.println("criteria.getRowStart() = " + criteria.getRowStart());
        System.out.println("criteria.getRowEnd() = " + criteria.getRowEnd());
        System.out.println("criteria.gegetSearchTypetRowEnd() = " + criteria.getSearchType());
        List<MemberCouponList> result = mypageMapper.findByCoupon(criteria, userId);
        log.info("result={}", result);
    }


    @Test
    void likefunding(){
        String userId = "user01";
//        List<LikeFundingDTO> result = mypageMapper.findLikeFundingById(userId);

//        log.info("resul={}", result);
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
        SearchCriteria criteria = new SearchCriteria();

//        List<MemberInquireListDTO> result = mypageMapper.findInquireAllById(userId);
//        log.info("result={}", result);
    }

    @Test
    void findReportAllById(){
        String userId = "user02";
//        List<MemberReportListDTO> result = mypageMapper.findReportAllById(userId);
//        log.info("result={}", result);
    }

    @Test
    void findSellerInquireById(){
        String userId = "user01";
        SearchCriteria criteria = new SearchCriteria();
        System.out.println("criteria = " + criteria);
//        criteria.setPage(3); //페이지 테스트
        criteria.setStatus("Y"); // 조건테스트
//        criteria.setSearchType("배송관련문의"); //조건테스트
        System.out.println("criteria.getPage() = " + criteria.getPage());
        System.out.println("criteria.getPageSize() = " + criteria.getPageSize());
        Pagination pagination = new Pagination(criteria,100);
        System.out.println("criteria.getRowStart() = " + criteria.getRowStart());
        System.out.println("criteria.getRowEnd() = " + criteria.getRowEnd());
        System.out.println("criteria.gegetSearchTypetRowEnd() = " + criteria.getSearchType());
//        List<MemberSellerInquireDTO> result = mypageMapper.findSellerInquireById(criteria, userId);
//        log.info("result={}", result);


//        int i = mypageMapper.listCount(criteria, userId);
//        log.info("i={}", i);
//        String s = criteria.makeQuery(1);
//        log.info("s={}",s);

    }
    @Test
    void valid(){
        int code = 26;


    }




}