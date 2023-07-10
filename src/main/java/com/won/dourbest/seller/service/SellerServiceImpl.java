package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.SellerMapper;
import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.ProductDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.*;
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
    public PointListDTO selectPoint() {

        PointListDTO point = mapper.selectPoint();




        return point;
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
        productPrice.setTotalPrice(totalPrice);

        return productPrice;
    }

    @Override
    public void selectMemberCode(int memberCode) {

    }

    @Override
    public ProductDTO selectProduct(int optionCode) {

        ProductDTO product = mapper.selectProduct(optionCode);

        return product;
    }


}
