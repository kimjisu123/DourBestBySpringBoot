package com.won.dourbest.customerService.controller;


import com.won.dourbest.admin.account.dto.AdminAccountDTO;
import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customerService")
public class ConstomerServiceController {

    @GetMapping("/customerService")
    public ModelAndView customerService(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){
        return mv;
    }

    @GetMapping("/coupon")
    public ModelAndView coupon(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/coupon");

        return mv;
    }

    @GetMapping("/delivery")
    public ModelAndView delivery(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/delivery");

        return mv;
    }

    @GetMapping("/exchange")
    public ModelAndView exchange(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/exchange");

        return mv;
    }

    @GetMapping("/member")
    public ModelAndView member(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/member");

        return mv;
    }

    @GetMapping("/membership")
    public ModelAndView membership(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/membership");

        return mv;
    }

    @GetMapping("/payment")
    public ModelAndView payment(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/payment");

        return mv;
    }

    @GetMapping("/refund")
    public ModelAndView refund(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/refund");

        return mv;
    }
    @GetMapping("/useService")
    public ModelAndView useService(ModelAndView mv){

        mv.setViewName("/customerService/customerServiceCategory/useService");

        return mv;
    }




}
