package com.won.dourbest.admin.coupon.controller;

import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;
import com.won.dourbest.admin.coupon.service.CouponServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class CouponController {

    private final CouponServiceImpl couponServiceImpl;
    public CouponController(CouponServiceImpl couponServiceImpl) {
        this.couponServiceImpl = couponServiceImpl;
    }

    // 쿠폰 발급 내역
    @GetMapping("/Issuance")
    public ModelAndView Issuance(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = couponServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }

        List<CouponIssuance> couponIssuanceList = couponServiceImpl.selectIssuanceList(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("couponIssuanceList", couponIssuanceList);
        mv.setViewName("admin/coupon/IssuanceCoupons");


        return mv;
    }

    // 쿠폰 사용 내역
    @GetMapping("/UseCoupon")
    public ModelAndView useCoupon(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = couponServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }

        List<UseCoupon> useCouponList = couponServiceImpl.selectUseCoupon(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("useCouponList", useCouponList);
        mv.setViewName("admin/coupon/useCoupon");


        
        return mv;
    }
}
