package com.won.dourbest.admin.report.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.report.dto.AnswerRegistDTO;
import com.won.dourbest.admin.report.dto.AnswerReportDTO;
import com.won.dourbest.admin.report.dto.ReportDetailsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    List<ReportDetailsDTO> selectReportDetails(SelectCriteria selectCriteria);

    List<AnswerReportDTO> selectAnswerReport(SelectCriteria selectCriteria);

    int selectTotalPage();

    // 신고 답변 등록
    int insertAnswer(String fundCode);

    // 유저 상태값 업데이트
    int updateSeller(String sellerCode);

    // 멤버 코드
    String selectMemberCode(String sellerCode);

    // 펀딩 코드
    String selectfundCode(AnswerRegistDTO answerRegist);

    // 판매자 코드
    String selectSellerCode(String fundCode);

    // 신고 누적 횟수 3 여부 조회
    String selectReported(String sellerCode);


    int insertBlackList(String sellerCode);


}
