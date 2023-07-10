package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.ProductDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.*;

import java.util.List;

public interface SellerService {


    public Integer registSeller(SellerDTO seller, MemberDTO member);

    FundingOptionDTO selectProductName();

    MemberDTO selectMember(String memberId);

    AddressDTO selectAddress(String memberId);

    List<CouponDTO> selectCouponList();

//    CouponDTO selectTotalCouponDC();

//    CouponDTO registCoupon(String contact);


    OrderDTO selectDelivery();

    ProductDTO registCoupon(String choiceCoupon, int optionCode);

    void selectMemberCode(int memberCode);

    ProductDTO selectProduct(int optionCode);

    ProductDTO selectPoint(String id);

    ProductDTO totalPrice(int totalPrice);


//    CouponDTO selectTotalPrice();

}
