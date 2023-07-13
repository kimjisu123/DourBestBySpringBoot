package com.won.dourbest.admin.report.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    // 신고 내역 조회
    List<ReportDetailsDTO> selectReportDetails(SelectCriteria selectCriteria);
    // 신고 처리 내역 조회
    List<AnswerReportDTO> selectAnswerReport(SelectCriteria selectCriteria);
    // 1:1 문의사항 조회
    List<CustomerInquiryDTO> selectInquiry(SelectCriteria selectCriteria);

    int selectTotalPage();

    // 유저 상태값 업데이트
    int updateSeller(String sellerCode);

    // 멤버 코드
    String selectMemberCode(String sellerCode);



    // 신고 누적 횟수 3 여부 조회
    String selectReported(String sellerCode);

    // 블랙리스트 등록
    int insertBlackList(String blackListMemberCode);


    // 판매자 코드
    String selectSellerCode(int fundingCode);

    // 펀딩 신고 코드
    int selectReportCode(int fundingCode, String reportTitle);


    // 신고 답변 등록
    int insertAnswer(int reportCode, AnswerRegistDTO answerRegist);

    // 펀딩 신고 상태값 업데이트
    int updateReport(int reportCode);

    // 1:1 문의사항 상태값 변경
    int updateInquiries(int inquriesCode);

    // 문의사항 답변 등록
    int insertQNARegist(int inquriesCode, String answerContent, int adminCode);
}
