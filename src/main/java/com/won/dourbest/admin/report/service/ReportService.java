package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dto.*;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<ReportDetailsDTO> selectReportDetails(SelectCriteria selectCriteria);

    List<AnswerReportDTO> selectAnswerReport(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);

    String answerRegist(AnswerRegistDTO answerRegist, int adminCode);

    List<CustomerInquiryDTO> selectInquiry(SelectCriteria selectCriteria);

    String userAnswerRegist(UserAnswerRegistDTO userAnswer, int adminCode);
}
