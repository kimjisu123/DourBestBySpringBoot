package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.common.dto.Criteria;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface MypageMapper {

    MypageDTO findById(String userId);


    List<MemberCouponList> findByCoupon(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<LikeFundingDTO> findLikeFundingById(String userId);

    List<PurchasedFundingListDTO> findPurchasedFundingById(String userId);

    List<MemberInquireListDTO> findInquireAllById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<MemberReportListDTO> findReportAllById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<MemberSellerInquireDTO> findSellerInquireById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    int listCount(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId, @Param("name") String name);

    int updateCouponStatus (int code);
}
