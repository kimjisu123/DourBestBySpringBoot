package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.SellerMapper;
import com.won.dourbest.seller.dto.*;
import com.won.dourbest.user.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
            throw new RuntimeException();

        }




        return memberCode;
    }

    @Override
    public FundingOptionDTO selectProductName(int optionCode) {

        FundingOptionDTO productName = mapper.selectProductName(optionCode);


        return productName;


    }

    // 주문자 정보 조회
    @Override
    public MemberDTO selectMember(String memberId) {

        MemberDTO member = mapper.selectMember(memberId);


        return member;
    }

    @Override
    public AddressDTO selectAddress(int memberCode) {

        AddressDTO address = mapper.selectAddress(memberCode);

        return address;
    }

    @Override
    public List<CouponDTO> selectCouponList(String memberId) {

        List<CouponDTO> couponList = mapper.selectCouponList(memberId);


        return couponList;
    }



    @Override
    public OrderDTO selectDelivery() {

        OrderDTO delivery = mapper.selectDelivery();


        return delivery;
    }




    @Override
    public ProductDTO registCoupon(String choiceCoupon, int optionCode) {
//        int result = 0;
//        int totalPrice = 0;
//        ProductDTO productPrice = mapper.selectProduct(optionCode);
//        for (int i = 0; i < choiceCoupon.length(); i++) {
//            if (choiceCoupon.equals("10%할인")) {
//                result = (int)(productPrice.getOptionPrice()*0.1);
//                totalPrice = productPrice.getOptionPrice() - result;
//            } else if(choiceCoupon.equals("5%할인")) {
//                result = (int)(productPrice.getOptionPrice()*0.05);
//                totalPrice = productPrice.getOptionPrice() - result;
//            } else if(choiceCoupon.equals("무료배송")) {
//                result = mapper.deleteDelivery();
//                if (result == 1) {
//                    totalPrice = productPrice.getOptionPrice();
//                }
//            }
//        }
//        productPrice.setDisCount(result);
//        productPrice.setPointTotalAmount(totalPrice);
//        productPrice.setDisCount(result);
        ProductDTO productPrice = mapper.selectProduct(optionCode);

        ProductDTO disCount = mapper.selectCoupon(choiceCoupon);
        int result = 0;
        int total = 0;

        if(disCount.getCouponDisCount() == 9999) {
            result = 9999;
            total= productPrice.getOptionPrice();
        } else {

            result = productPrice.getOptionPrice()*(disCount.getCouponDisCount())/100;
            total = productPrice.getOptionPrice() - result;
        }



        productPrice.setCouponDisCount(result);
        productPrice.setPointTotalAmount(total);

        System.out.println("result : " + result);

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
    public OrderDTO insertOrder(OrderDTO order, int mCode) {

        // 멤버코드



        // 펀딩코드
        FundingDTO fundingCode = mapper.selectfundingCode(order.getFundingOptionCode());
        System.out.println("fundingCode = " + fundingCode);

        int fundCode = fundingCode.getFundingCode();


        int optionCode = Integer.parseInt(order.getFundingOptionCode());

        int update = mapper.update(optionCode);

        String cp = order.getCoupon();
        Map<String, Object> map = new HashMap<>();
        map.put("mCode" , mCode);
        map.put("fundCode", fundCode);
        map.put("cp", cp);
        int purchase = mapper.insertPurchase(map);
        int couponCode = mapper.selectCoupon1(map);
        map.put("couponCode", couponCode);
        int result1 = mapper.couponUpdate(map);
        // 쿠폰리스트 코드
        CouponListDTO couponCode1 = mapper.selectCouponCode(map);

        order.setMemberCode(mCode);
        order.setFundingCode(fundingCode.getFundingCode());
        order.setCouponlistCode(String.valueOf(couponCode1.getCouponlistCode()));
        
        
        int result = mapper.insertOrder(order);
        System.out.println("order = " + order);
        // 오더코드
        int orderCode = order.getOrderCode();

        if(result >= 1) {
            System.out.println("주문 등록 성공");
        } else {
            System.out.println("주문 등록 실패");
        }





        return order;
    }

    @Override
    public PaymentDTO insertPayment(PaymentDTO payment) {

        Random random = new Random();

        int credit = mapper.insertPayment(payment);

        if (credit >= 1) {
            System.out.println("결제 등록 성공");
        } else {
            System.out.println("결제 등록 실패");
        }

        System.out.println("paymentCode = " + payment.getPaymentCode());

        long num = (long) (Math.random() * 999999999999L + 100000000000L);
        // 운송장 번호 랜덤으로 만듬
//        List<Integer> deliveryNumber = new ArrayList<>();
//        for (int i = 1; i <= 12; i++) {
//            deliveryNumber.add( random.nextInt(9) + 1);
//
//        }
//        System.out.println(deliveryNumber);
//
//        String num = "";
//
//        for(int j = 0; j < deliveryNumber.size(); j++) {
//            num += deliveryNumber.get(j);
//        }
        // 운송장 번호
        System.out.println(num);



        SellerDeliveryDTO delivery = new SellerDeliveryDTO();
        delivery.setDeliveryNumber(num);
        delivery.setPaymentCode(payment.getPaymentCode());

        int result = mapper.insertDelivery(delivery);

        if (result >= 1 ){
            System.out.println("배송등록 성공");
        } else {
            System.out.println("배송등록 실패");
        }

        System.out.println(delivery.getDeliveryCode());

        int deliveryLIst = mapper.insertDeliveryList(delivery.getDeliveryCode());

        if (deliveryLIst >= 1) {
            System.out.println("배송리스트 등록 성공");
        } else {
            System.out.println("배송리스트 등록 실패");
        }

        return payment;
    }

    @Override
    @Transactional
    public int insertFundingCreditList(int paymentCode) {

        int fundingCredit = mapper.insertFundingCreditList(paymentCode);

        if (fundingCredit >= 1) {
            System.out.println("펀딩 결제 내역 등록 성공");
        } else {
            System.out.println("펀팅 결제 내역 등록 실패");
        }


        return paymentCode;
    }

    @Override
    @Transactional
    public int updateCoupon(DisCountDTO dc, int memberCode) {

        // 쿠폰 사용 업데이트
        int couponCode = mapper.updateCoupon(memberCode);

        if (couponCode >= 1) {
            System.out.println("쿠폰 사용처리 성공");
        } else {
            System.out.println("쿠폰 사용처리 실패");
        }
        // 포인트 사용

        int point = mapper.updatePoint(dc.getUsePoint(),memberCode);

        return 0;
    }

    @Override
    public ProductDTO selectUserPoint(String memberId, int usePoint) {

        ProductDTO point = mapper.selectPoint(memberId);

        if (point.getPointTotalAmount() < usePoint) {
           throw new RuntimeException();
        }

        System.out.println("point.getPoint() = " + point.getPointTotalAmount());

        return null;
    }


    public OptionDTO selectOption(int optionCode) {

        OptionDTO option = mapper.selectOption(optionCode);

        return option;
    }

    public int selectVIP(int memberCode) {

        int vip = mapper.selectVIP(memberCode);

        return vip;
    }

    public int selectCategory(int fundingCode) {

        int categoryCode = mapper.selectCatogory(fundingCode);

        return categoryCode;
    }
}



