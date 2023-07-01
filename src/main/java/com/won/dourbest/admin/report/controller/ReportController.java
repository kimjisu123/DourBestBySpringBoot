package com.won.dourbest.admin.report.controller;

import com.won.dourbest.admin.report.dto.ReportDetailsDTO;
import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.service.ReportServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReportController {

    private final ReportServiceImpl reportServiceImpl;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ReportController(ReportServiceImpl reportServiceImpl) {

        this.reportServiceImpl = reportServiceImpl;

    }

    @GetMapping("reportDetails")
    public ModelAndView reportDetails(ModelAndView mv){

        List<ReportDetailsDTO> reportDetailsList = reportServiceImpl.selectReportDetails();

        mv.addObject("reportDetailsList", reportDetailsList);
        mv.setViewName("admin/report/reportResolution");

        return mv;
    }

    @GetMapping("answerReport")
    public ModelAndView blackList(ModelAndView mv){

        List<AnswerReportDTO> responseList = reportServiceImpl.selectAnswerReport();

        mv.addObject("responseList", responseList);
        mv.setViewName("admin/report/answerReport");

        log.info("responseList : " + responseList);

        return mv;
    }
}
