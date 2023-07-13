package com.won.dourbest.admin.coupon.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.coupon.dto.CouponIssuanceDTO;
import com.won.dourbest.admin.coupon.dto.CouponRegistDTO;
import com.won.dourbest.admin.coupon.dto.UseCouponDTO;

import java.util.List;
import java.util.Map;

public interface CouponService {

    // 쿠폰 발급 내역
    List<CouponIssuanceDTO> selectIssuanceList(SelectCriteria selectCriteria);

    List<UseCouponDTO> selectUseCoupon(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);

    String couponRegist(CouponRegistDTO coupon);

    int selectRegiTotalPage(Map<String, String> searchMap);
}
