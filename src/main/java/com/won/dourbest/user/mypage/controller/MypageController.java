package com.won.dourbest.user.mypage.controller;

import com.won.dourbest.common.dto.Pagination;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.CouponListDTO;
import com.won.dourbest.user.dto.MemberSellerInquireDTO;
import com.won.dourbest.user.dto.MypageDTO;
import com.won.dourbest.user.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String couponPage(Model model){

        /* 세션에서 멤버 가져와서 id 값을 이용하자 */
        String userId = "user01";

        List<CouponListDTO> memberCoupons = mypageService.allCoupon(userId);

        model.addAttribute("memberCoupons", memberCoupons);

        return "user/mypage/coupon";
    }

    @GetMapping("/seller-inquire")
    public String selleIinquire(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria,userId));

        log.info("criteria.getPage={}",criteria.getPage());
        log.info("criteria.getPageSize={}",criteria.getPageSize());
        log.info("criteria.getRowStart={}",criteria.getRowStart());
        log.info("pagination.getStartPage={}",pagination.getStartPage());
        log.info("pagination.getEndPage={}",pagination.getEndPage());
        log.info("pagination.={}",pagination);

        List<MemberSellerInquireDTO> list = mypageService.sellerInquire(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);
//        model.addAttribute("url", criteria.makeQuery(pagination.getCriteria().getPage()));
//        model.addAttribute("test",criteria);
        return "user/mypage/sellerInquire";
    }


}
