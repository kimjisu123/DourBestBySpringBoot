package com.won.dourbest.admin.report.dao;

import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    List<ReportDetailsDTO> selectReportDetails();

    List<AnswerReportDTO> selectAnswerReport();
}
