package com.won.dourbest.admin.report.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dao.ReportMapper;
import com.won.dourbest.admin.report.dto.AnswerRegistDTO;
import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;
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
        // 회원 코드
        String memberCode;

        // 가져오는 코드에 대한 트랜잭션
        fundingCode = answerRegist.getFundingCode();

        reportCode  = mapper.selectReportCode(fundingCode);

        sellerCode = mapper.selectSellerCode(fundingCode);

        // 신고 답변 등록
        int result;
        // 유저 상태값 업데이트
        int result1;
        // 펀딩 신고 상태값 업데이트 여부
        int result2;
        // 신고 누적횟수가 3일 경우 블랙리스트
        int result3;

        // 신고 답변 등록
        result = mapper.insertAnswer(reportCode, answerRegist);
        if (result != 0) {
            // 유저 상태값 업데이트
            result1 = mapper.updateSeller(sellerCode);
            if (result1 != 0) {
                // 펀딩 신고 상태값 업데이트
                result2 = mapper.updateReport(reportCode);
                if (result2 != 0) {
                    return "성공적으로 제재가 되었습니다.";
                }
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }

        // 신고 누적 횟수 3 여부 3일 경우 MEMBER_CODE 반환
        memberCode = mapper.selectReported(sellerCode);

        // 신고 누적 횟수가 3인 경우
        if (memberCode != null) {
            // 블랙리스트 등록
            result3 = mapper.insertBlackList(memberCode);
            if (result3 != 0) {
                // 성공시 반환
                return "블랙리스트에 등록이 되었습니다.";
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }

        }









}
