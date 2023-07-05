package com.won.dourbest.seller.controller;

import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.seller.service.SellerService;
import com.won.dourbest.seller.service.SellerServiceImpl;
import com.won.dourbest.user.dto.*;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Controller
@RequestMapping("/seller")
public class SellerController {


    private final SellerServiceImpl service;


    public SellerController (SellerServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/application")
    public String seller() {

        return "seller/giwon_seller/seller_application";
    }

    @PostMapping("/application")
    public String seller(HttpServletRequest request , @ModelAttribute SellerDTO seller ,@ModelAttribute MemberDTO member){


        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String license = request.getParameter("license");
        System.out.println("license : " + license);
        System.out.println(id);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);

        member.setMemberId(id);
        member.setMemberName(name);
        member.setMemberPhone(phone);
        member.setMemberEmail(email);
        seller.setBusinessLicense(license);


        service.registSeller(seller, member);



        return "seller/giwon_seller/seller_application";
    }

    @GetMapping("/success")
    public String success() {

        return "seller/giwon_seller/seller_success";
    }

    // 상품명 조회
    @GetMapping("/payment")
    public String payment(Model model, HttpServletRequest request ) {

        FundingOptionDTO product = service.selectProductName();


        model.addAttribute("product", product);

        // 주문자 정보 조회
        MemberDTO member = service.selectMember();

        model.addAttribute("member", member);

        // 배송지 조회
        AddressDTO address = service.selectAddress();

        model.addAttribute("address", address);

        // 회원이 가지고 있는 쿠폰 목록

        List<CouponDTO> couponName = service.selectCouponList();

        model.addAttribute("couponName" , couponName);


        // 보유 포인트

        PointListDTO point = service.selectPoint();

        model.addAttribute("point" , point);

        // 배송비

        OrderDTO delivery = service.selectDelivery();

        model.addAttribute("delivery" , delivery );

        return "seller/giwon_seller/payment_page";
    }

    @PostMapping("/payment")
    @ResponseBody
    public int payment(@RequestParam("choiceCoupon") String choiceCoupon ) {


        System.out.println("choiceCoupon = " + choiceCoupon);
        // 쿠폰 사용
        int couponApply = service.registCoupon(choiceCoupon);



        return couponApply;
    }









}
