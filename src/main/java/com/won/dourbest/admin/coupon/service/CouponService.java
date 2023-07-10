package com.won.dourbest.admin.coupon.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;

import java.util.List;
import java.util.Map;

public interface CouponService {

    // 쿠폰 발급 내역
    List<CouponIssuance> selectIssuanceList(SelectCriteria selectCriteria);

    List<UseCoupon> selectUseCoupon(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);

    String couponIssuance();
}
