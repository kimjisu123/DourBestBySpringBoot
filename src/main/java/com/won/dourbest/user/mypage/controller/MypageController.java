package com.won.dourbest.user.mypage.controller;

import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.dto.Pagination;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.*;
import com.won.dourbest.user.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;

    @GetMapping
    public String mypage(Model model){

        /* 세션에서 멤버 가져와서 id 값을 이용하자 */
        String userId = "user01";

        MypageDTO mypageInfo = mypageService.myPageinfo(userId);

        model.addAttribute("mypageInfo", mypageInfo);

        return "user/mypage/mypage";
    }

    @GetMapping("/coupon")
    public String couponPage(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        /* 세션에서 멤버 가져와서 id 값을 이용하자 */
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "sellerInquire"));

        List<MemberCouponList> list = mypageService.allCoupon(criteria, userId);

        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/coupon";
    }

    @GetMapping("/seller-inquire")
    public String selleInquire(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "sellerInquire"));

        List<MemberSellerInquireDTO> list = mypageService.sellerInquire(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/sellerInquire";
    }

    @GetMapping("/inquire")
    public String adminInquire(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "adminInquire"));

        List<MemberInquireListDTO> list = mypageService.adminInquire(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/adminInquire";
    }

    @GetMapping("/report")
    public String reportList(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "report"));

        List<MemberReportListDTO> list = mypageService.reportList(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/report";
    }

    @PostMapping(value = "/coupon/regist")
    @ResponseBody
    public ResponseEntity<CommonResponse> couponRegist(@ModelAttribute MemberCouponList code){

        CommonResponse response = new CommonResponse(true,"쿠폰등록성공");
        int i = mypageService.couponRegister(code.getCouponListCode());
        log.info("i={}", i);
        log.info("code={}", code);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
