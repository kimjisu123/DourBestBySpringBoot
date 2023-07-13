package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.*;
import com.won.dourbest.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerMapper {
    Integer selectMemberCode(MemberDTO member);
    int insertSeller(SellerDTO seller);

    FundingOptionDTO selectProductName(int optionCode);

    MemberDTO selectMember(String memberId);

    AddressDTO selectAddress(String memberId);

    List<CouponDTO> selectCouponList();
    

    OrderDTO selectDelivery();

    int deleteDelivery();

    ProductDTO selectProduct(int optionCode);

    int selectProductPrice();

    ProductDTO selectPoint(String id);

  

   


    OrderDTO selectOrderCode(Integer memberCode);

    FundingCreditDTO registCredit(String orderCode);

    

    OrderDTO selectOrder(int optionCode);


    FundingDTO selectfundingCode(String fundingOptionCode);

 

    int insertOrder(OrderDTO order);

    CouponListDTO selectCouponCode(Integer memberCode);


    int insertPayment(PaymentDTO payment);

    int insertFundingCreditList(int paymentCode);

    int selectDeliveryPrice(int paymentCode);

    int insertDelivery(SellerDeliveryDTO delivery);

    int insertDeliveryList(int deliveryCode);

    ProductDTO selectCoupon(String choiceCoupon);

    int updateCoupon(int memberCode);

    int selectUseCoupon(int memberCode);

    int updatePoint(int usePoint, int memberCode);
}
