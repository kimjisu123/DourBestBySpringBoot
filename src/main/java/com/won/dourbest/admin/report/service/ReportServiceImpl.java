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
        String fundCode;
        // 판매자 코드
        String sellerCode;

        // 신고 답변 등록
        int result;
        // 유저 상태값 업데이트
        int result1;
        // 신고 누적횟수가 3일 경우 블랙리스트
        int result2;

        // 신고 누적 횟수 3 여부 3일 경우 MEMBER_CODE 반환
        String memberCode;


        String message;

        fundCode = mapper.selectfundCode(answerRegist);
        sellerCode = mapper.selectSellerCode(fundCode);


        // 신고 답변 등록
        result = mapper.insertAnswer(fundCode);

        try {
            if(result != 0){
                // 유저 상태값 업데이트
                result1 = mapper.updateSeller(sellerCode);
                if(result1 != 0){
                     message ="성공적으로 제재가 되었습니다.";
                } else{
                    throw new RuntimeException();
                }
            } else{
                throw new RuntimeException();
            }
        } catch (RuntimeException e){
            throw new RuntimeException();
        }

        // 신고 누적 횟수 3 여부 3일 경우 MEMBER_CODE 반환
        memberCode = mapper.selectReported(sellerCode);

        if(memberCode != null){
            // 신고 누적 횟수가 3인 유저 블랙리스트 등록
            result2 = mapper.insertBlackList(memberCode);

            if(result2 != 0){
                return "블랙리스트에 등록이 되었습니다.";
            }else {
                throw new RuntimeException();
            }
        }


        return message;


    }


}
