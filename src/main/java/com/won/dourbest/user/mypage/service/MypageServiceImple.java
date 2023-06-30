package com.won.dourbest.user.mypage.service;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.common.exception.user.CouponNotFoundException;
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
    public List<MemberCouponList> allCoupon(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findByCoupon(searchCriteria, userId);
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

    @Override
    public int couponRegister(int code) {
        int result = mypageMapper.updateCouponStatus(code);

        if(result > 0) throw new CouponNotFoundException("해당하는 쿠폰코드가 없어요!") ;

        return result;
    }


}
