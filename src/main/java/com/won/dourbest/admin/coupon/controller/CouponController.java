package com.won.dourbest.admin.coupon.controller;

import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;
import com.won.dourbest.admin.coupon.service.CouponServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CouponController {

    private final CouponServiceImpl couponServiceImpl;
    public CouponController(CouponServiceImpl couponServiceImpl) {
        this.couponServiceImpl = couponServiceImpl;
    }

    // 쿠폰 발급 내역
    @GetMapping("/Issuance")
    public ModelAndView Issuance(ModelAndView mv){

        List<CouponIssuance> couponIssuanceList = couponServiceImpl.selectIssuanceList();

        mv.addObject("couponIssuanceList", couponIssuanceList);
        mv.setViewName("admin/coupon/IssuanceCoupons");

        System.out.println("couponIssuanceList = " + couponIssuanceList);
        
        return mv;
    }

    // 쿠폰 사용 내역
    @GetMapping("/UseCoupon")
    public ModelAndView useCoupon(ModelAndView mv){

        List<UseCoupon> useCouponList = couponServiceImpl.selectUseCoupon();

        mv.addObject("useCouponList", useCouponList);
        mv.setViewName("admin/coupon/useCoupon");

        System.out.println("useCouponList = " + useCouponList);
        
        return mv;
    }
}
