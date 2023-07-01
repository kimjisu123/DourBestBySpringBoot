package com.won.dourbest.admin.coupon.service;

import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;

import java.util.List;

public interface CouponService {

    // 쿠폰 발급 내역
    List<CouponIssuance> selectIssuanceList();

    List<UseCoupon> selectUseCoupon();
}
