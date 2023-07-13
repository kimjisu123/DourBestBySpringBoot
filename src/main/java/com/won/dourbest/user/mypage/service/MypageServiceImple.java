package com.won.dourbest.user.mypage.service;

import com.won.dourbest.admin.account.dto.AdminInquiriesDTO;
import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.common.exception.user.CouponNotFoundException;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import com.won.dourbest.user.dto.*;
import com.won.dourbest.user.mypage.repository.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MypageServiceImple implements MypageService{

    private final MypageMapper mypageMapper;

    @Override
    @Transactional
    public Map<String,Object> myPageinfo(String userId) {
        HashMap<String, Object> mypageInfo = new HashMap<>();
        MypageMainDTO mypageMain = mypageMapper.findById(userId);
        MypageDTO delivery = mypageMapper.findDelivery(userId);
        mypageInfo.put("mypageMain",mypageMain);
        mypageInfo.put("delivery",delivery);

        return mypageInfo;
    }

    @Override
    public MypageMainDTO info(String userId) {
        return mypageMapper.findById(userId);
    }


    @Override
    public List<MemberCouponList> allCoupon(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findByCoupon(searchCriteria, userId);
    }

    @Override
    public List<MemberInquireListDTO> adminInquire(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findInquireAllById(searchCriteria, userId);
    }

    @Override
    public List<MemberSellerInquireDTO> sellerInquire(SearchCriteria criteria, String userId) {

        return mypageMapper.findSellerInquireById(criteria, userId);
    }

    @Override
    public List<MemberReportListDTO> reportList(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findReportAllById(searchCriteria, userId);
    }

    @Override
    public List<PurchasedFundingListDTO> purchaseList(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findPurchasedFundingById(searchCriteria,userId);
    }

    @Override
    public List<MemberPointDTO> pointList(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findByPoint(searchCriteria,userId);
    }

    @Override
    public List<LikeFundingDTO> likeFundingList(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.findLikeFundingById(searchCriteria,userId);
    }

    @Override
    public List<LikeFundingDTO> myFundingList(SearchCriteria searchCriteria, String userId) {
        return mypageMapper.myFunding(searchCriteria,userId);
    }

    @Override
    public int listTotalCount(SearchCriteria searchCriteria, String userId, String name) {
        return mypageMapper.listCount(searchCriteria, userId, name);
    }

    @Override
    public int couponRegister(int code) {

        int result = mypageMapper.updateCouponStatus(code);
        System.out.println(",apper:"+result);
        if(result == 0) throw new CouponNotFoundException("해당하는 쿠폰코드가 없어요!") ;

        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> OrderAndCreditInfo(String userId, int orderCode) {

        OrderFundingDTO byOrder = mypageMapper.findByOrder(userId, orderCode);
        OrderCreditDTO byCredit = mypageMapper.findByCredit(orderCode);
        List<CategoryDTO> category = mypageMapper.contactCategory();
        int reviewCount = mypageMapper.reviewCount(userId, byOrder.getFundingCode());

        Map<String,Object> info = new HashMap<>();

        info.put("order", byOrder);
        info.put("credit", byCredit);
        info.put("contactCategory", category);
        info.put("reviewCount", reviewCount);

        return info;
    }

    @Override
    public int changeProfile(ProfileDTO profile) {
        return mypageMapper.updateProfile(profile);
    }

//     문의사항 세부내역
    @Override
    @Transactional
    public AdminInquiriesDTO QnaInqurireAnwser(int memberCode , int id) {


        return  mypageMapper.QnaInqurireAnwser(memberCode, id);
    }

    @Override
    @Transactional
    public SellerInquiryDTO QnaSellerInquire(int memberCode, int id) {
        return mypageMapper.QnaSellerInquire(memberCode,id);
    }

    @Override
    @Transactional
    public MemberReportListDTO NotifyInquire(int memberCode, int id) {
        return mypageMapper.NotifyInquire(memberCode,id);
    }


}