package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.SellerMapper;
import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.*;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerMapper mapper;



    public SellerServiceImpl(SellerMapper mapper) {
        this.mapper = mapper;
    }



    @Override
    @Transactional
    public Integer registSeller(SellerDTO seller , MemberDTO member) {

        Integer memberCode = mapper.selectMemberCode(member);

        seller.setMemberCode(memberCode);



        int result = 0;

        if (memberCode != null) {
            result = mapper.insertSeller(seller);
            System.out.println("신청 성공");
        } else if (memberCode == null){
            System.out.println("판매자 신청 실패");
        }

        return memberCode;
    }

    @Override
    public FundingOptionDTO selectProductName() {

        FundingOptionDTO productName = mapper.selectProductName();


        return productName;


    }

    // 주문자 정보 조회
    @Override
    public MemberDTO selectMember() {

        MemberDTO member = mapper.selectMember();



        System.out.println(member);

        return member;
    }

    @Override
    public AddressDTO selectAddress() {

        AddressDTO address = mapper.selectAddress();

        return address;
    }

    @Override
    public List<CouponDTO> selectCouponList() {

        List<CouponDTO> couponList = mapper.selectCouponList();
        System.out.println("couponList : " + couponList);

        return couponList;
    }

//    @Override
//    public CouponDTO selectTotalCouponDC() {
//
//        OrderDTO total = mapper.selectTotalPrice();
//
//        CouponDTO disCount = mapper.selectDIsCount();
//
//
//
//        return null;
//    }

    @Override
    public CouponDTO registCoupon(String contact) {

        CouponDTO disCount = mapper.registCoupon(contact);

        if(disCount.getCouponDiscount() == 5) {

        }

        return disCount;
    }


}
