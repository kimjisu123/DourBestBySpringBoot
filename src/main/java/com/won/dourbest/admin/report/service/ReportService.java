package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;

import java.util.List;

public interface ReportService {
    List<ReportDetailsDTO> selectReportDetails();

    List<AnswerReportDTO> selectAnswerReport();
}
