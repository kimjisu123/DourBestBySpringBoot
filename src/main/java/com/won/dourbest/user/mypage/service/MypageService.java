package com.won.dourbest.user.mypage.service;

import com.won.dourbest.user.dto.MemberCouponListDTO;
import com.won.dourbest.user.dto.MypageDTO;
import org.springframework.stereotype.Service;

public interface MypageService {

    public MypageDTO myPageinfo(String userId);

    public MemberCouponListDTO allCoupon(String userId);

}
