package com.won.dourbest.admin.coupon.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CouponMapper {

    List<CouponIssuance> selectIssuanceList(SelectCriteria selectCriteria);

    List<UseCoupon> selectUseCoupon(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);
    int couponIssuance();
}
