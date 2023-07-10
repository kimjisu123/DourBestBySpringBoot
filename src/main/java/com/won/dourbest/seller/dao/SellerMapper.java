package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.ProductDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerMapper {
    Integer selectMemberCode(MemberDTO member);
    int insertSeller(SellerDTO seller);

    FundingOptionDTO selectProductName( );

    MemberDTO selectMember(String memberId);

    AddressDTO selectAddress(String memberId);

    List<CouponDTO> selectCouponList();

    

    CouponDTO selectDIsCount();

    CouponDTO registCoupon(String contact);

    PointListDTO selectPoint();

    OrderDTO selectDelivery();

    int deleteDelivery();

    ProductDTO selectProduct(int optionCode);

    int selectProductPrice();
}
