package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dto.AnswerRegistDTO;
import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.CustomerInquiryDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<ReportDetailsDTO> selectReportDetails(SelectCriteria selectCriteria);

    List<AnswerReportDTO> selectAnswerReport(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);

    String answerRegist(AnswerRegistDTO answerRegist);

    List<CustomerInquiryDTO> selectInquiry(SelectCriteria selectCriteria);
}
