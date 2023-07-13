package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dao.ReportMapper;
import com.won.dourbest.admin.report.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
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

        int fundingCode;
        int reportCode;
        String sellerCode;
        String reportTitle;
        String blackListMemberCode;

        reportTitle = answerRegist.getChoiceValue();

        fundingCode = answerRegist.getFundingCode();

        sellerCode = mapper.selectSellerCode(fundingCode);

        reportCode  = mapper.selectReportCode(fundingCode, reportTitle);

        int result;
        int result1;
        int result2;
        int result3;
        String message="";

        result = mapper.insertAnswer(reportCode, answerRegist);
        if (result != 0) {
            result1 = mapper.updateSeller(sellerCode);
            if (result1 != 0) {
                result2 = mapper.updateReport(reportCode);
                if (result2 != 0) {
                    message =  "성공적으로 제재가 되었습니다.";
                }
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }

        blackListMemberCode = mapper.selectReported(sellerCode);


        if (blackListMemberCode != null) {

            result3 = mapper.insertBlackList(blackListMemberCode);
            if (result3 != 0) {
                // 성공시 반환
                message = "블랙리스트에 등록이 되었습니다.";
            } else {
                throw new RuntimeException();
            }
        }
        return message;
    }






    // 1:1 문의사항 내역 조회
    @Override
    public List<CustomerInquiryDTO> selectInquiry(SelectCriteria selectCriteria) {


        List<CustomerInquiryDTO> customerInquiry = mapper.selectInquiry(selectCriteria);


        return customerInquiry;
    }
    // 1:1 문의사항 답변
    @Override
    public String userAnswerRegist(UserAnswerRegistDTO userAnswer, int adminCode) {

        // 문의사항 답변 등록
        int result;

        // 1:1 문의사항 상태값 변경
        int result2;

        // 1:1 문의사항 코드
        int inquriesCode;

        // 문의사항 답변 내용
        String answerContent;

        inquriesCode = userAnswer.getInquiriesCode();


        answerContent = userAnswer.getAnswerContent();




        result = mapper.insertQNARegist(inquriesCode, answerContent, adminCode);
        if(result != 0){
            result2 = mapper.updateInquiries(inquriesCode);
            if(result2 != 0){
                return "답변 등록에 성공하셨습니다";
            } else{
                throw new RuntimeException();
            }
        }throw new RuntimeException();


    }


}
