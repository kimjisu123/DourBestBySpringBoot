package com.won.dourbest.user.mypage.service;

import com.won.dourbest.user.dto.CouponListDTO;
import com.won.dourbest.user.dto.MypageDTO;

import java.util.List;

public interface MypageService {

    public MypageDTO myPageinfo(String userId);

    public List<CouponListDTO> allCoupon(String userId);

}
