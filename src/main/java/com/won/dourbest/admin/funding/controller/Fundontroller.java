package com.won.dourbest.admin.funding.controller;


import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import com.won.dourbest.admin.funding.service.FundingListServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class Fundontroller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final FundingListServiceImpl fundingListService;
    public Fundontroller(FundingListServiceImpl fundingListService) {
        this.fundingListService = fundingListService;
    }

    // 오픈 예정 펀딩 목록
    @GetMapping("willopen")
    public ModelAndView willopenFunding(ModelAndView mv){

        List<AdminFundingDTO> willopenFundingList = fundingListService.selectAllWillopen();

        mv.addObject("willopenFundingList", willopenFundingList);
        mv.setViewName("admin/funding/willopenfunding");


        return mv;
    }

    // 진행중인 펀딩 목록
    @GetMapping("ongoing")
    public ModelAndView ongoingFunding(ModelAndView mv){

        List<AdminFundingDTO> ongoingFundingList = fundingListService.selectAllOngoing();

        mv.addObject("ongoingFundingList", ongoingFundingList);
        mv.setViewName("admin/funding/ongoingFunding");

        return mv;
    }

    // 완료된 펀딩 목록
    @GetMapping("finished")
    public ModelAndView finishedFunding(ModelAndView mv){

        List<AdminFundingDTO> finishedFundingList = fundingListService.selectAllFinished();

        mv.addObject("finishedFundingList", finishedFundingList);
        mv.setViewName("admin/funding/finishedFunding");

        log.info("ongoingFundingList : " + finishedFundingList);
        return mv;
    }

    // 승인된 펀딩 목록
    @GetMapping("approved")
    public ModelAndView approvedFunding(ModelAndView mv){

    List<AdminFundingDTO> approvedFundingList = fundingListService.selectAllapproved();

    mv.addObject("approvedFundingList", approvedFundingList);
    mv.setViewName("admin/funding/approvedFunding");

    log.info("approvedFundingList : " + approvedFundingList);

        return mv;
    }

    // 신청한 펀딩 목록
    @GetMapping("applied")
    public ModelAndView fundingApplied(ModelAndView mv){

        List<AdminFundingDTO> fundingAppliedList = fundingListService.selectAllApplied();

        mv.addObject("fundingAppliedList", fundingAppliedList);
        mv.setViewName("admin/funding/fundingApplied");

        return mv;
    }

    // 판매자 등록 신청 목록

    @GetMapping("sellerRegi")
    public ModelAndView sellerRegistration(ModelAndView mv){

        List<AdminFundingDTO> sellerRegiList = fundingListService.selectAllSellerRegiList();

        mv.addObject("sellerRegiList", sellerRegiList);
        mv.setViewName("admin/funding/sellerRegistration");

        log.info("sellerRegiList : " + sellerRegiList);

        return mv;
    }
}
