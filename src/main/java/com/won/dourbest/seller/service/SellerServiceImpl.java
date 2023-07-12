package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.SellerMapper;
import com.won.dourbest.seller.dto.*;
import com.won.dourbest.user.dto.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerMapper mapper;


    public SellerServiceImpl(SellerMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public Integer registSeller(SellerDTO seller, MemberDTO member) {

        Integer memberCode = mapper.selectMemberCode(member);

        seller.setMemberCode(memberCode);


        int result = 0;

        if (memberCode != null) {
            result = mapper.insertSeller(seller);
            System.out.println("신청 성공");
        } else if (memberCode == null) {
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
    public MemberDTO selectMember(String memberId) {

        MemberDTO member = mapper.selectMember(memberId);


        return member;
    }

    @Override
    public AddressDTO selectAddress(String memberId) {

        AddressDTO address = mapper.selectAddress(memberId);

        return address;
    }

    @Override
    public List<CouponDTO> selectCouponList() {

        List<CouponDTO> couponList = mapper.selectCouponList();


        return couponList;
    }



    @Override
    public OrderDTO selectDelivery() {

        OrderDTO delivery = mapper.selectDelivery();


        return delivery;
    }




    @Override
    public ProductDTO registCoupon(String choiceCoupon, int optionCode) {
        int result = 0;
        int totalPrice = 0;
        ProductDTO productPrice = mapper.selectProduct(optionCode);
        for (int i = 0; i < choiceCoupon.length(); i++) {
            if (choiceCoupon.equals("10%할인")) {
                result = (int)(productPrice.getOptionPrice()*0.1);
                totalPrice = productPrice.getOptionPrice() - result;
            } else if(choiceCoupon.equals("5%할인")) {
                result = (int)(productPrice.getOptionPrice()*0.05);
                totalPrice = productPrice.getOptionPrice() - result;
            } else if(choiceCoupon.equals("무료배송")) {
                result = mapper.deleteDelivery();
                if (result == 1) {
                    totalPrice = productPrice.getOptionPrice();
                }
            }
        }
        productPrice.setDisCount(result);
        productPrice.setPointTotalAmount(totalPrice);
        productPrice.setDisCount(result);


        return productPrice;
    }



    @Override
    public ProductDTO selectProduct(int optionCode) {

        ProductDTO product = mapper.selectProduct(optionCode);

        return product;
    }

    @Override
    public ProductDTO selectPoint(String id) {
        
        
        ProductDTO point = mapper.selectPoint(id);
        System.out.println("point.getPoint() = " + point.getPointTotalAmount());

        return point;

    }

    @Override
    public ProductDTO totalPrice(int totalPrice) {


        return null;
    }

    @Override
    @Transactional
    public OrderDTO insertOrder(OrderDTO order, String memberId) {

        // 멤버코드
        MemberDTO memberCode = mapper.selectMember(memberId);
        System.out.println("memberCode : " + memberCode.getMemberCode());

        // 펀딩코드
        FundingDTO fundingCode = mapper.selectfundingCode(order.getFundingOptionCode());
        System.out.println("fundingCode = " + fundingCode);

        // 쿠폰리스트 코드
        CouponListDTO couponCode = mapper.selectCouponCode(memberCode.getMemberCode());

        order.setMemberCode(memberCode.getMemberCode());
        order.setFundingCode(fundingCode.getFundingCode());
        order.setCouponlistCode(String.valueOf(couponCode.getCouponlistCode()));
        
        
        int result = mapper.insertOrder(order);
        int orderCode = order.getOrderCode();

        System.out.println("orderCode = " + orderCode);
        // 오더코드


        if(result >= 1) {
            System.out.println("주문 등록 성공");
        } else {
            System.out.println("주문 등록 실패");
        }




        return order;
    }


}



