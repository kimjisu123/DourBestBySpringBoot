package com.won.dourbest.user.mypage.service;

import com.won.dourbest.common.dto.SearchCriteria;
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

    List<LikeFundingDTO> likeFundingList(SearchCriteria searchCriteria, String userId);
    public List<PurchasedFundingListDTO> purchaseList(SearchCriteria searchCriteria, String userId);

    public int listTotalCount(SearchCriteria searchCriteria, String userId, String name);

    public int couponRegister(int code);

    public Map<String,Object> OrderAndCreditInfo(String userId, int orderCode);

}
