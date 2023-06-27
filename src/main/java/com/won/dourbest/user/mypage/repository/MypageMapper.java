package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.user.dto.MemberCouponListDTO;
import com.won.dourbest.user.dto.MypageDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

    MypageDTO findById(String userId);

    MemberCouponListDTO findByCoupon(String userId);

}
