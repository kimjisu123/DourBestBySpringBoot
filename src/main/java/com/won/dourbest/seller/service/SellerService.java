package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.FundingCreditDTO;
import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.ProductDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface SellerService {


    public Integer registSeller(SellerDTO seller, MemberDTO member);

    FundingOptionDTO selectProductName();

    MemberDTO selectMember(String memberId);

    AddressDTO selectAddress(String memberId);

    List<CouponDTO> selectCouponList();

    OrderDTO selectDelivery();

    ProductDTO registCoupon(String choiceCoupon, int optionCode);

    ProductDTO selectProduct(int optionCode);

    ProductDTO selectPoint(String id);

    ProductDTO totalPrice(int totalPrice);


    OrderDTO insertOrder(OrderDTO order, String memberId);
}
