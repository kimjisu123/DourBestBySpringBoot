package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.*;

import java.util.List;

public interface SellerService {


    public Integer registSeller(SellerDTO seller, MemberDTO member);

    FundingOptionDTO selectProductName();

    MemberDTO selectMember();

    AddressDTO selectAddress();

    List<CouponDTO> selectCouponList();

//    CouponDTO selectTotalCouponDC();

//    CouponDTO registCoupon(String contact);

    PointListDTO selectPoint();

    OrderDTO selectDelivery();

    int registCoupon(String map);




//    CouponDTO selectTotalPrice();

}
