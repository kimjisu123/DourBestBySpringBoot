package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.user.dto.CouponListDTO;
import com.won.dourbest.user.dto.MypageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {

    MypageDTO findById(String userId);

    List<CouponListDTO> findByCoupon(String userId);

}
