package com.won.dourbest.admin.coupon.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.coupon.dto.CouponIssuanceDTO;
import com.won.dourbest.admin.coupon.dto.CouponRegistDTO;
import com.won.dourbest.admin.coupon.dto.UseCouponDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CouponMapper {

    List<CouponIssuanceDTO> selectIssuanceList(SelectCriteria selectCriteria);

    List<UseCouponDTO> selectUseCoupon(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);

    // 쿠폰 등록
    int couponRegist(CouponRegistDTO coupon);


    // 모든 멤버의 멤버코드
    List<Integer> selectAllMemberCodes();


    // 모든 멤버에게 쿠폰 등록
    int insertCoupon(Date date, int memCode);

    int selectRegiTotalPage();
}
