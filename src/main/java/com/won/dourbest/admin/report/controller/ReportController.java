package com.won.dourbest.admin.report.controller;

import com.won.dourbest.admin.account.dto.AdminImpl;
import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dto.*;
import com.won.dourbest.admin.report.service.ReportServiceImpl;
import com.won.dourbest.common.exception.member.NoLoginException;
import com.won.dourbest.user.dto.MemberImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ReportController {

    private final ReportServiceImpl reportServiceImpl;


//    public ReportController(ReportServiceImpl reportServiceImpl) {
//
//        this.reportServiceImpl = reportServiceImpl;
//
//    }

    @GetMapping("reportDetails")
    public ModelAndView reportDetails(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = reportServiceImpl.selectTotalPage(searchMap);

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


        List<ReportDetailsDTO> reportDetailsList = reportServiceImpl.selectReportDetails(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("reportDetailsList", reportDetailsList);
        mv.setViewName("admin/report/reportResolution");

        return mv;
    }

    @GetMapping("answerReport")
    public ModelAndView blackList(ModelAndView mv, @RequestParam(required = false) String searchValue,
                                    @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        int totalPage = reportServiceImpl.selectTotalPage(searchMap);

        int limit = 8;

        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);
        }

        List<AnswerReportDTO> responseList = reportServiceImpl.selectAnswerReport(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("responseList", responseList);
        mv.setViewName("admin/report/answerReport");


        return mv;
    }

    @GetMapping("/customerInquiry")
    public ModelAndView customerInquiry(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = reportServiceImpl.selectTotalPage(searchMap);

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


        List<CustomerInquiryDTO> customerInquiry = reportServiceImpl.selectInquiry(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("customerInquiry", customerInquiry);


        mv.setViewName("admin/report/customerInquiry");

        return mv;
    }


    // 제재 답변
    @PostMapping("answerRegist")
    @ResponseBody
    public String answerRegist(@RequestBody AnswerRegistDTO answer){

        System.out.println("answer = " + answer);
        
        String message = reportServiceImpl.answerRegist(answer);

        return message;
    }

    // 1:1 문의 답변
    @PostMapping("customerInquiry")
    @ResponseBody
    public String userAnswerRegist( @RequestBody UserAnswerRegistDTO inquiry, @AuthenticationPrincipal AdminImpl admin){

        if(admin == null){
            throw new NoLoginException();
        }

        int adminCode = admin.getAdminCode();

        String message = reportServiceImpl.userAnswerRegist(inquiry, adminCode);

        return message;
    }




}
