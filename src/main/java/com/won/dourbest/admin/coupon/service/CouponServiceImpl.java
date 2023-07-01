package com.won.dourbest.admin.coupon.service;

import com.won.dourbest.admin.coupon.dao.CouponMapper;
import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService{

    private final CouponMapper mapper;
    public CouponServiceImpl(CouponMapper mapper) {
        this.mapper = mapper;
    }

    // 쿠폰 발급 내역
    @Override
    public List<CouponIssuance> selectIssuanceList() {

        List<CouponIssuance> couponIssuanceList = mapper.selectIssuanceList();

        return couponIssuanceList;
    }

    // 쿠폰 사용 내역
    @Override
    public List<UseCoupon> selectUseCoupon() {

        List<UseCoupon> useCoupon = mapper.selectUseCoupon();

        return useCoupon;
    }
}
