package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dao.ReportMapper;
import com.won.dourbest.admin.report.dto.AnswerRegistDTO;
import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService{

    private final ReportMapper mapper;

    public ReportServiceImpl(ReportMapper mapper) {
        this.mapper = mapper;
    }

    // 신고 내역 조회
    @Override
    public List<ReportDetailsDTO> selectReportDetails(SelectCriteria selectCriteria) {

        List<ReportDetailsDTO> reportDetailsList = mapper.selectReportDetails(selectCriteria);

        return reportDetailsList;
    }

    // 신고 답변 조회
    @Override
    public List<AnswerReportDTO> selectAnswerReport(SelectCriteria selectCriteria) {

        List<AnswerReportDTO> responseList = mapper.selectAnswerReport(selectCriteria);

        return responseList;
    }

    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectTotalPage();
        return result;
    }

    @Override
    public String answerRegist(AnswerRegistDTO answerRegist) {

        // 신고 답변 등록
        int result;
        int result1;
        String fundCode;
        String sellerCode;

        String message = "";

        fundCode = mapper.selectfundCode(answerRegist);
        sellerCode = mapper.selectSellerCode(fundCode);
        result = mapper.insertAnswer(fundCode);
        if(result != 0){
            result1 = mapper.updateSeller(sellerCode);
            if(result1 != 0){
                message = "성공하셨습니다";
            } else{
                message = "실패함";
            }
        } else{
            message =  "실패함;";
        }

        return "";
    }


}
