package com.won.dourbest.seller.controller;

import com.siot.IamportRestClient.IamportClient;
import com.won.dourbest.common.exception.member.NoLoginException;
import com.won.dourbest.seller.dto.*;
import com.won.dourbest.seller.service.SellerServiceImpl;
import com.won.dourbest.user.dto.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;


@Controller
@RequestMapping("/seller")
public class SellerController {


    private final SellerServiceImpl service;
    private IamportClient api;


    public SellerController (SellerServiceImpl service, IamportClient api) {
        this.service = service;
        this.api = new IamportClient("5775185238551285","nOLrNJUiWs7mVQRrPVP3I7N44OZAk6VIDJ5SplkOKo6fWHK8gz2hgLf0pfY9v3mtPfPJkVLgnXnTG4lV");
    }


    @GetMapping("/application")
    public String seller(@AuthenticationPrincipal MemberImpl member) {

        if(member == null) {
            throw new NoLoginException("로그인 안됨");
        }

        return "seller/giwon_seller/seller_application";
    }

    @PostMapping("/application")
    @ResponseBody
    public Integer seller(HttpServletRequest request , @ModelAttribute SellerDTO seller ,@ModelAttribute MemberDTO member){


        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String license = request.getParameter("license");
        String newPhone = phone.replace("-", "");
        System.out.println("license : " + license);
        System.out.println(id);
        System.out.println(name);
        System.out.println(newPhone);
        System.out.println(email);

        member.setMemberId(id);
        member.setMemberName(name);
        member.setMemberPhone(newPhone);
        member.setMemberEmail(email);
        seller.setBusinessLicense(license);


        Integer selectMember = service.registSeller(seller, member);


        return selectMember;
    }

    @GetMapping("/success")
    public String success() {

        return "seller/giwon_seller/seller_success";
    }

    @PostMapping("/success")
    public String success1() {

        return "seller/giwon_seller/seller_success";
    }

    @GetMapping("/fail")
    public String fail() {

        return "seller/giwon_seller/fundingCreditSuccess";
    }

    // 상품명 조회
    @GetMapping("/payment/{optionCode}")
    public String payment(Model model, HttpServletRequest request , @AuthenticationPrincipal MemberImpl member, @PathVariable int optionCode) {

        if(member == null) {
            throw new NoLoginException("로그인 안됨");
        }

        OptionDTO option = service.selectOption(optionCode);

        model.addAttribute("option", option);

        int memberCode = member.getMemberCode();
        int fundingCode = option.getFundingCode();
        int vip = service.selectVIP(memberCode);
        int categoryCode = service.selectCategory(fundingCode);

        AddressDTO address = service.selectAddress(memberCode);
        int deliverPrice = 0;

        if(vip == 2 || categoryCode == 19) {
            deliverPrice = 0;
        } else {
            deliverPrice = 3000;
        }


        model.addAttribute("address", address);
        model.addAttribute("deliverPrice", deliverPrice);
        model.addAttribute("member", member);

//        FundingOptionDTO product = service.selectProductName(optionCode);
//
//        model.addAttribute("product", product);
//        model.addAttribute("optionCode", optionCode);
//
//        // 주문자 정보 조회
//        MemberDTO member = service.selectMember(id.getMemberId());
////
//
//        model.addAttribute("member", member);
//
//        // 배송지 조회
//        AddressDTO address = service.selectAddress(id.getMemberId());
//
//        model.addAttribute("address", address);
//
//        // 회원이 가지고 있는 쿠폰 목록
//
        List<CouponDTO> couponName = service.selectCouponList(member.getMemberId());

        model.addAttribute("couponName" , couponName);

//        // 포인트 조회
        ProductDTO pointAmount = service.selectPoint(member.getMemberId());

        model.addAttribute("pointAmount", pointAmount );
//
//        // 배송비
//
//        OrderDTO delivery = service.selectDelivery();
//
//        model.addAttribute("delivery" , delivery );
//
//        System.out.println("memberId : " + id);
//
//        // 최종 결제 금액




        return "seller/giwon_seller/payment_page";
    }

    @PostMapping("/coupon")
    @ResponseBody
    public Map<String, String> payment(@RequestParam("choiceCoupon") String choiceCoupon ,@RequestParam int optionCode) {

        Map<String, String> map = new HashMap<>();
        System.out.println("choiceCoupon = " + choiceCoupon);
        // 쿠폰 사용
        ProductDTO couponApply = service.registCoupon(choiceCoupon,optionCode);
        System.out.println("couponApply = " + couponApply);
        map.put("coupon" , String.valueOf(couponApply.getPointTotalAmount()));
        map.put("disCount", String.valueOf(couponApply.getCouponDisCount()));


        return map;
    }

    @PostMapping("/point")
    @ResponseBody
    public int point(@RequestParam int usePoint,@AuthenticationPrincipal MemberImpl id ) {

        ProductDTO point = service.selectUserPoint(id.getMemberId(), usePoint);

        System.out.println("usePoint : " + usePoint);


        return usePoint;
    }

    @PostMapping("/option")
    @ResponseBody
    public ProductDTO option(@RequestParam int optionCode) {

        ProductDTO product = service.selectProduct(optionCode);

        return product;
    }

    @PostMapping("/totalPrice")
    @ResponseBody
    public int totalPrice(@RequestParam int totalPrice) {

        return totalPrice;
    }


    @PostMapping("/order")
    @ResponseBody
    public OrderDTO order(@RequestBody @Valid OrderDTO order, @AuthenticationPrincipal MemberImpl id ) {

        System.out.println("order : " + order.getFundingOptionCode());
        int memberCode = id.getMemberCode();
        order.setMemberCode(memberCode);
        System.out.println("order : " + order);
        OrderDTO insertOrder = service.insertOrder(order, memberCode);


        System.out.println(insertOrder.getOrderCode());



        return insertOrder;
    }

    @PostMapping("/credit")
    @ResponseBody
    public PaymentDTO credit(@RequestBody @Valid PaymentDTO payment) {

        System.out.println("이거다" + payment.getOrderCode());

        PaymentDTO credit = service.insertPayment(payment);

        return credit;
    }

    @PostMapping("/creditList")
    @ResponseBody
    public int credit(@RequestParam("paymentCode") int paymentCode) {

        int fundingList = service.insertFundingCreditList(paymentCode);


        return paymentCode;
    }





//    @GetMapping("/cards/{card_standard_code}")
//    @ResponseBody
//    public IamportResponse<Payment> Import(Model model, Locale locale, HttpSession session, @PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {
//
//        return api.paymentByImpUid(imp_uid);
//    }




}
