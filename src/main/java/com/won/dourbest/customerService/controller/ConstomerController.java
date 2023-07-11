package com.won.dourbest.customerService.controller;


import com.won.dourbest.customerService.dto.ConstomerContactDTO;
import com.won.dourbest.customerService.service.ConstomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customerService")
public class ConstomerController {

    private final ConstomerServiceImpl constomerServiceImpl;
    public ConstomerController(ConstomerServiceImpl constomerServiceImpl) {
        this.constomerServiceImpl = constomerServiceImpl;
    }

    @GetMapping("/customerService")
    public ModelAndView customerService(ModelAndView mv){

    List<ConstomerContactDTO> contactList =  constomerServiceImpl.selectCoupon();

    mv.addObject("contactList", contactList);
    mv.setViewName("customerService/customerService");

        return mv;
    }
    // 쿠폰
    @GetMapping("/coupon")
    public ModelAndView coupon(ModelAndView mv){


        List<ConstomerContactDTO> couponList =  constomerServiceImpl.selectContact();

        mv.addObject("couponList", couponList);
        mv.setViewName("/customerService/customerServiceCategory/coupon");

        return mv;
    }

    // 상품/배송
    @GetMapping("/delivery")
    public ModelAndView delivery(ModelAndView mv){

        List<ConstomerContactDTO> deliveryList =  constomerServiceImpl.selectDelivery();

        mv.addObject("deliveryList", deliveryList);
        mv.setViewName("/customerService/customerServiceCategory/delivery");

        return mv;
    }
    // 교환 AS
    @GetMapping("/exchange")
    public ModelAndView exchange(ModelAndView mv){

        List<ConstomerContactDTO> exchangeList =  constomerServiceImpl.selecteExchange();

        mv.addObject("exchangeList", exchangeList);
        mv.setViewName("/customerService/customerServiceCategory/exchange");

        return mv;
    }
    // 회원정보
    @GetMapping("/member")
    public ModelAndView member(ModelAndView mv){

        List<ConstomerContactDTO> memberList =  constomerServiceImpl.selectMember();

        mv.addObject("memberList", memberList);
        mv.setViewName("/customerService/customerServiceCategory/member");

        return mv;
    }
    // 멤버십
    @GetMapping("/membership")
    public ModelAndView membership(ModelAndView mv){

        List<ConstomerContactDTO> membershipList =  constomerServiceImpl.selectMembership();

        mv.addObject("membershipList", membershipList);
        mv.setViewName("/customerService/customerServiceCategory/membership");

        return mv;
    }
    // 결제
    @GetMapping("/payment")
    public ModelAndView payment(ModelAndView mv){

        List<ConstomerContactDTO> paymentList =  constomerServiceImpl.selectPayment();

        mv.addObject("paymentList", paymentList);
        mv.setViewName("/customerService/customerServiceCategory/payment");

        return mv;
    }
    // 취소 환불 반품
    @GetMapping("/refund")
    public ModelAndView refund(ModelAndView mv){

        List<ConstomerContactDTO> refundList =  constomerServiceImpl.selectRefund();

        mv.addObject("refundList", refundList);
        mv.setViewName("/customerService/customerServiceCategory/refund");

        return mv;
    }
    // 서비스 이용 문의
    @GetMapping("/useService")
    public ModelAndView useService(ModelAndView mv){

        List<ConstomerContactDTO> useServiceList =  constomerServiceImpl.selectUseService();

        mv.addObject("useServiceList", useServiceList);
        mv.setViewName("/customerService/customerServiceCategory/useService");

        return mv;
    }




}
