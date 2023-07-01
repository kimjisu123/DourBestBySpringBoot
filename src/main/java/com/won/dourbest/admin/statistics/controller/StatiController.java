package com.won.dourbest.admin.statistics.controller;

import com.won.dourbest.admin.statistics.dto.StatiDTO;
import com.won.dourbest.admin.statistics.service.StatiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StatiController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final StatiServiceImpl statiServiceImpl;

    public StatiController(StatiServiceImpl statiServiceImpl) {

        this.statiServiceImpl = statiServiceImpl;
    }


    // 총 금액 순으로 조회
    @GetMapping("allPrice")
    public ModelAndView allPrice(ModelAndView mv){

        List<StatiDTO> statiAllPriceList = statiServiceImpl.selectAllPrice();

        mv.setViewName("admin/statistics/allPrice");
        mv.addObject("statiAllPriceList", statiAllPriceList);

        return mv;
    }

    // 총 조회수 순으로 조회
    @GetMapping("allViews")
    public ModelAndView allViews(ModelAndView mv){

        List<StatiDTO> statiAllViewsList = statiServiceImpl.selectAllViews();

        mv.setViewName("admin/statistics/allInquiry");
        mv.addObject("statiAllViewsList", statiAllViewsList);

        return mv;

    }

    // 총 좋아요 순으로 조회
    @GetMapping("allLikes")
    public ModelAndView allLikes(ModelAndView mv){

        List<StatiDTO> statiallLikesList = statiServiceImpl.selectAllLikes();

        mv.setViewName("admin/statistics/allGood");
        mv.addObject("statiallLikesList", statiallLikesList);

        return mv;

    }

    // 월 기준 금액순으로 조회
    @GetMapping("monthPrice")
    public ModelAndView monthPrice(ModelAndView mv){

        List<StatiDTO> statiMonthPriceList = statiServiceImpl.selectMonthPrice();

        mv.setViewName("admin/statistics/monthPrice");
        mv.addObject("statiMonthPriceList", statiMonthPriceList);

        return mv;
    }

    // 월 기준 조회수 순으로 조회
    @GetMapping("monthViews")
    public ModelAndView monthViews(ModelAndView mv){

        List<StatiDTO> statiMonthViewsList = statiServiceImpl.selectMonthViews();

        mv.setViewName("admin/statistics/monthInquiry");
        mv.addObject("statiMonthViewsList", statiMonthViewsList);

        return mv;

    }

    // 월 기준 좋아요 순으로 조회
    @GetMapping("monthLikes")
    public ModelAndView monthLikes(ModelAndView mv){

        List<StatiDTO> statiMonthLikesList = statiServiceImpl.selectMonthLikes();

        mv.setViewName("admin/statistics/monthGood");
        mv.addObject("statiMonthLikesList", statiMonthLikesList);

        return mv;

    }

}
