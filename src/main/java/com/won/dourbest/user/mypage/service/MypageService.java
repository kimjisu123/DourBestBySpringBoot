package com.won.dourbest.user.mypage.service;

import com.won.dourbest.admin.dto.AdminInquiriesDTO;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import com.won.dourbest.user.dto.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MypageService {

    public Map<String,Object> myPageinfo(String userId);

    public List<MemberCouponList> allCoupon(SearchCriteria searchCriteria, String userId);

    public List<MemberInquireListDTO> adminInquire(SearchCriteria searchCriteria, String userId);

    public List<MemberSellerInquireDTO> sellerInquire(SearchCriteria searchCriteria, String userId);

    public List<MemberReportListDTO> reportList(SearchCriteria searchCriteria, String userId);

    public List<PurchasedFundingListDTO> purchaseList(SearchCriteria searchCriteria, String userId);

    public List<MemberPointDTO> pointList(SearchCriteria searchCriteria, String userId);

    List<LikeFundingDTO> likeFundingList(SearchCriteria searchCriteria, String userId);

    public int listTotalCount(SearchCriteria searchCriteria, String userId, String name);

    public int couponRegister(int code);

    public Map<String,Object> OrderAndCreditInfo(String userId, int orderCode);

    public int changeProfile(ProfileDTO profile);

    public AdminInquiriesDTO QnaInqurireAnwser(int memberCode , int id);

    public SellerInquiryDTO QnaSellerInquire(int memberCode , int id);

    public MemberReportListDTO NotifyInquire(int memberCode , int id);

}
