package com.won.dourbest.user.mypage.service;

import com.won.dourbest.user.dto.CouponListDTO;
import com.won.dourbest.user.dto.MypageDTO;
import com.won.dourbest.user.mypage.repository.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


}
