package com.won.dourbest.user.mypage.service;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.*;
import com.won.dourbest.user.mypage.repository.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageServiceImple implements MypageService{

    private final MypageMapper mypageMapper;

    @Override
    public MypageDTO myPageinfo(String userId) {
        return mypageMapper.findById(userId);
    }

    @Override
    public List<CouponListDTO> allCoupon(String userId) {
        return mypageMapper.findByCoupon(userId);
    }

    @Override
    public List<MemberInquireListDTO> adminInquire(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findInquireAllById(searchCriteria, userId);
    }

    @Override
    public List<MemberSellerInquireDTO> sellerInquire(SearchCriteria criteria, String userId) {

        return mypageMapper.findSellerInquireById(criteria, userId);
    }

    @Override
    public List<MemberReportListDTO> reportList(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findReportAllById(searchCriteria, userId);
    }


    @Override
    public int listTotalCount(SearchCriteria searchCriteria, String userId, String name) {
        return mypageMapper.listCount(searchCriteria, userId, name);
    }

}
