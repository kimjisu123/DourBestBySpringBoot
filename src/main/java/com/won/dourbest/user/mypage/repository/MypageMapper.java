package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.admin.account.dto.AdminInquiriesDTO;
import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import com.won.dourbest.user.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MypageMapper {

    MypageMainDTO findById(String userId);

    MypageDTO findDelivery(String userId);

    List<MemberCouponList> findByCoupon(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<LikeFundingDTO> findLikeFundingById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<PurchasedFundingListDTO> findPurchasedFundingById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<MemberInquireListDTO> findInquireAllById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<MemberReportListDTO> findReportAllById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    List<MemberSellerInquireDTO> findSellerInquireById(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);
    List<LikeFundingDTO> myFunding(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    int listCount(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId, @Param("name") String name);

    int updateCouponStatus (int code);

    OrderFundingDTO findByOrder(@Param("userId") String userId, @Param("orderCode") int orderCode);

    OrderCreditDTO findByCredit(int orderCode);

    List<CategoryDTO> contactCategory();

    List<MemberPointDTO> findByPoint(@Param("cri") SearchCriteria searchCriteria, @Param("userId") String userId);

    int updateProfile(ProfileDTO profiles);

    int reviewCount(@Param("userId") String userId, @Param("fundingCode") int fundingCode);

    AdminInquiriesDTO QnaInqurireAnwser(int memberCode ,int id);

    SellerInquiryDTO QnaSellerInquire(int memberCode , int id);

    MemberReportListDTO NotifyInquire(int memberCode , int id);

}
