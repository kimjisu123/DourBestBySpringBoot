package com.won.dourbest.user.mypage.controller;

import com.won.dourbest.user.dto.CouponListDTO;
import com.won.dourbest.user.dto.MypageDTO;
import com.won.dourbest.user.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String couponPage(Model model){

        /* 세션에서 멤버 가져와서 id 값을 이용하자 */
        String userId = "user01";

        List<CouponListDTO> memberCoupons = mypageService.allCoupon(userId);

        model.addAttribute("memberCoupons", memberCoupons);

        return "user/mypage/coupon";
    }


}
