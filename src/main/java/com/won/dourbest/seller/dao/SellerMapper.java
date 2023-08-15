package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.*;
import com.won.dourbest.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SellerMapper {
    Integer selectMemberCode(MemberDTO member);
    int insertSeller(SellerDTO seller);

    FundingOptionDTO selectProductName(int optionCode);

    MemberDTO selectMember(String memberId);

    AddressDTO selectAddress(int memberCode);

    List<CouponDTO> selectCouponList(String memberId);
    

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

    CouponListDTO selectCouponCode(Map<String, Object> map);


    int insertPayment(PaymentDTO payment);

    int insertFundingCreditList(int paymentCode);

    int selectDeliveryPrice(int paymentCode);

    int insertDelivery(SellerDeliveryDTO delivery);

    int insertDeliveryList(int deliveryCode);

    ProductDTO selectCoupon(String choiceCoupon);

    int updateCoupon(int memberCode);

    int selectUseCoupon(int memberCode);

    int updatePoint(int usePoint, int memberCode);

    int update(FundingDTO fundingCode);

    int update(int optionCode);

    OptionDTO selectOption(int optionCode);

    int selectVIP(int memberCode);

    int selectCatogory(int fundingCode);

    int couponUpdate(Map<String, Object> couponCode);

    int selectCoupon1(Map<String, Object> cp);

    int insertPurchase(Map<String, Object> map);

    int insertRefundRule(Map<String, Object> map);
}
