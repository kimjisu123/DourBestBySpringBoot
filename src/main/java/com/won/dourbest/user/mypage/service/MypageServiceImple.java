package com.won.dourbest.user.mypage.service;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.CouponListDTO;
import com.won.dourbest.user.dto.MemberSellerInquireDTO;
import com.won.dourbest.user.dto.MypageDTO;
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
    public List<MemberSellerInquireDTO> sellerInquire(SearchCriteria criteria, String userId) {

        return mypageMapper.findSellerInquireById(criteria, userId);
    }

    @Override
    public int listTotalCount(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.listCount(searchCriteria, userId);
    }

}
