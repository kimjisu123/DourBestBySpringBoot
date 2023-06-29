package com.won.dourbest.admin.funding.controller;


import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import com.won.dourbest.admin.funding.service.FundingListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FundingController {
    private final FundingListServiceImpl fundingListService;
    public FundingController(FundingListServiceImpl fundingListService) {
        this.fundingListService = fundingListService;
    }

    // 오픈 예정 펀딩 목록
    @GetMapping("/willopen")
    public ModelAndView willopenFunding(ModelAndView mv){

        List<AdminFundingDTO> willopenFundingList = fundingListService.selectAllWillopen();

        mv.addObject("willopenFundingList", willopenFundingList);
        mv.setViewName("admin/funding/willopenfunding");

        return mv;
    }

    // 진행중인 펀딩 목록
    @GetMapping("/ongoing")
    public ModelAndView ongoingFunding(ModelAndView mv){

        List<AdminFundingDTO> ongoingFundingList = fundingListService.selectAllOngoing();

        mv.addObject("ongoingFundingList", ongoingFundingList);
        mv.setViewName("admin/funding/ongoingFunding");

        return mv;
    }

    // 완료된 펀딩 목록
    @GetMapping("/finished")
    public ModelAndView finishedFunding(ModelAndView mv){

        List<AdminFundingDTO> finishedFundingList = fundingListService.selectAllFinished();

        mv.addObject("finishedFundingList", finishedFundingList);
        mv.setViewName("admin/funding/finishedFunding");

        return mv;
    }

    // 승인된 펀딩 목록
    @GetMapping("/approved")
    public ModelAndView approvedFunding(ModelAndView mv){

    List<AdminFundingDTO> approvedFundingList = fundingListService.selectAllapproved();

    mv.addObject("approvedFundingList", approvedFundingList);
    mv.setViewName("admin/funding/approvedFunding");

        return mv;
    }

    // 신청한 펀딩 목록
    // 판매자 등록 신청 목록
    // 반려된 펀딩 목록
}
