package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.report.dao.ReportMapper;
import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private final ReportMapper mapper;

    public ReportServiceImpl(ReportMapper mapper) {
        this.mapper = mapper;
    }

    // 신고 내역 조회
    @Override
    public List<ReportDetailsDTO> selectReportDetails() {

        List<ReportDetailsDTO> reportDetailsList = mapper.selectReportDetails();

        return reportDetailsList;
    }

    // 신고 답변 조회
    @Override
    public List<AnswerReportDTO> selectAnswerReport() {

        List<AnswerReportDTO> responseList = mapper.selectAnswerReport();

        return responseList;
    }
}
