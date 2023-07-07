package com.won.dourbest.admin.funding.controller;


import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import com.won.dourbest.admin.funding.dto.AdminSellerRegistDTO;
import com.won.dourbest.admin.funding.service.FundingListServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class FundController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final FundingListServiceImpl fundingListService;
    public FundController(FundingListServiceImpl fundingListService) {
        this.fundingListService = fundingListService;
    }

    // 오픈 예정 펀딩 목록
    @GetMapping("willopen")
    public ModelAndView willopenFunding(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = fundingListService.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<AdminFundingDTO> willopenFundingList = fundingListService.selectAllWillopen(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("willopenFundingList", willopenFundingList);
        mv.setViewName("admin/funding/willopenfunding");


        return mv;
    }

    // 진행중인 펀딩 목록
    @GetMapping("ongoing")
    public ModelAndView ongoingFunding(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = fundingListService.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<AdminFundingDTO> ongoingFundingList = fundingListService.selectAllOngoing(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("ongoingFundingList", ongoingFundingList);
        mv.setViewName("admin/funding/ongoingFunding");

        return mv;
    }

    // 완료된 펀딩 목록
    @GetMapping("finished")
    public ModelAndView finishedFunding(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = fundingListService.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }

        List<AdminFundingDTO> finishedFundingList = fundingListService.selectAllFinished(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("finishedFundingList", finishedFundingList);
        mv.setViewName("admin/funding/finishedFunding");

        log.info("ongoingFundingList : " + finishedFundingList);
        return mv;
    }

    // 승인된 펀딩 목록
    @GetMapping("approved")
    public ModelAndView approvedFunding(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = fundingListService.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }

        List<AdminFundingDTO> approvedFundingList = fundingListService.selectAllapproved(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("approvedFundingList", approvedFundingList);
        mv.setViewName("admin/funding/approvedFunding");

        log.info("approvedFundingList : " + approvedFundingList);

        return mv;
    }

    // 신청한 펀딩 목록
    @GetMapping("applied")
    public ModelAndView fundingApplied(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = fundingListService.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }
        List<AdminFundingDTO> fundingAppliedList = fundingListService.selectAllApplied(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("fundingAppliedList", fundingAppliedList);
        mv.setViewName("admin/funding/fundingApplied");

        return mv;
    }

    // 판매자 등록 신청 목록

    @GetMapping("sellerRegi")
    public ModelAndView sellerRegistration(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = fundingListService.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<AdminSellerRegistDTO> sellerRegiList = fundingListService.selectAllSellerRegiList(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("sellerRegiList", sellerRegiList);
        mv.setViewName("admin/funding/sellerRegistration");

        log.info("sellerRegiList : " + sellerRegiList);

        return mv;
    }
}
