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

        // 펀딩 코드
        int fundingCode;
        // 펀딩신고 코드
        int reportCode;
        // 판매자 코드
        String sellerCode;
        // 신고 제목
        String reportTitle;


        // 회원 코드 (블랙리스트 용) 값이 있을시 블랙리스트 처리
        String blackListMemberCode;

        reportTitle = answerRegist.getChoiceValue();

        fundingCode = answerRegist.getFundingCode();

        sellerCode = mapper.selectSellerCode(fundingCode);





        System.out.println("sellerCode = " + sellerCode);
        System.out.println("fundingCode = " + fundingCode);

        reportCode  = mapper.selectReportCode(fundingCode, reportTitle);


        // 신고 답변 등록
        int result;
        // 유저 상태값 업데이트
        int result1;
        // 펀딩 신고 상태값 업데이트 여부
        int result2;
        // 신고 누적횟수가 3일 경우 블랙리스트
        int result3;

        String message="";

        // 신고 답변 등록 (신고코드, 입력한 값)
        result = mapper.insertAnswer(reportCode, answerRegist);
        if (result != 0) {
            // 유저 상태값 업데이트 (판매자 코드)
            result1 = mapper.updateSeller(sellerCode);
            if (result1 != 0) {
                // 펀딩 신고 상태값 업데이트 (신고 코드)
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

        // 신고 누적 횟수 3 여부 3일 경우 MEMBER_CODE 반환
        blackListMemberCode = mapper.selectReported(sellerCode);

        // 신고 누적 횟수가 3인 경우
        if (blackListMemberCode != null) {
            // 블랙리스트 등록
            result3 = mapper.insertBlackList(blackListMemberCode);
            if (result3 != 0) {
                // 성공시 반환
                message = "블랙리스트에 등록이 되었습니다.";
            } else {
                throw new RuntimeException();
            }
        } else {
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
