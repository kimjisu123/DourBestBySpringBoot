package com.won.dourbest.admin.coupon.dao;

import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {

    List<CouponIssuance> selectIssuanceList();

    List<UseCoupon> selectUseCoupon();
}
