package com.won.dourbest.admin.funding.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.funding.dao.AdminFundingMapper;
import com.won.dourbest.admin.funding.dto.AdminFundingDTO;
import com.won.dourbest.admin.funding.dto.AdminSellerRegistDTO;
import com.won.dourbest.admin.funding.dto.ApprovedDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FundingListServiceImpl implements FundingListService {
    // 매퍼 생성자
    private final AdminFundingMapper mapper;
    public FundingListServiceImpl(AdminFundingMapper mapper) {
        this.mapper = mapper;
    }

    // 오픈 예정 펀딩 조회
    @Override
    public List<AdminFundingDTO> selectAllWillopen(SelectCriteria selectCriteria) {
        List<AdminFundingDTO> willopenFundingList = mapper.selectAllWillopen(selectCriteria);

        return willopenFundingList;
    }

    // 진행중인 펀딩 조회
    @Override
    public List<AdminFundingDTO> selectAllOngoing(SelectCriteria selectCriteria) {
        List<AdminFundingDTO> ongoingFundingList = mapper. selectAllOngoing(selectCriteria);

        return ongoingFundingList;
    }

    // 완료된 펀딩 목록
    @Override
    public List<AdminFundingDTO> selectAllFinished(SelectCriteria selectCriteria) {
        List<AdminFundingDTO> finishedFundingList = mapper.selectAllFinished(selectCriteria);

        return finishedFundingList;
    }

    // 승인된 펀딩 목록
    @Override
    public List<AdminFundingDTO> selectAllapproved(SelectCriteria selectCriteria) {

        List<AdminFundingDTO> approvedFundingList = mapper.selectAllapproved(selectCriteria);

        return approvedFundingList;
    }
    // 신청한 펀딩 목록
    @Override
    public List<AdminFundingDTO> selectAllApplied(SelectCriteria selectCriteria) {
        List<AdminFundingDTO> fundingAppliedList = mapper.selectAllApplied(selectCriteria);

        return fundingAppliedList;
    }

    // 판매자 등록 신청 목록
    @Override
    public List<AdminSellerRegistDTO> selectAllSellerRegiList(SelectCriteria selectCriteria) {

        List<AdminSellerRegistDTO> sellerRegiList = mapper.selectAllSellerRegiList(selectCriteria);

        System.out.println("sellerRegiList = " + sellerRegiList);
        
        return sellerRegiList;

    }

    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectTotalPage(searchMap);

        return result;
    }

    // 판매자 등록 신청
    @Override
    public String insertSellerRegist(String memberId) {

        // memberId로 memberCode를 찾는 코드
        String memberCode = mapper.selectMemberCode(memberId);
        System.out.println(memberCode);

        int result;
        int result2;

        try {
            // 권한부여
            result = mapper.insertSellerRegist(memberCode);
            // 상태값 수정 승인대기 => 승인완료
            result2 = mapper.updateSellerRegist(memberCode);
            System.out.println("result2 + result = " + result2 + result);
            if(result != 0 && result2 != 0){
                return "판매자 등록에 성공하셨습니다!";
            } else{
                throw new RuntimeException("판매자 등록에 실패하셧습니다");
            }
        } catch ( RuntimeException e){
            throw new RuntimeException("판매자 등록에 실패하셧습니다");
        }



    }

    // 오픈 예정 펀딩 승인
    @Override
    public String Approval(String choiceValue) {

        String message = "";
        String fundingCode;
        // 펀딩 코드
        fundingCode = mapper.selectFundingCode(choiceValue);

        // 반려에 대한 결과
        int result1 = mapper.Approval(fundingCode);

        if(result1 != 0){
            message = "승인에 성공 하셨습니다.";
        } else{
            message = "승인에 실패 하셨습니다.";
        }

        return message;
    }


    // 오픈 예정 펀딩 반려
    @Override
    public String updateDeleteWillopen(String choiceValue) {

        String message = "";
        String fundingCode;
        // 펀딩 코드
        fundingCode = mapper.selectFundingCode(choiceValue);

        // 승인에 대한 결과
        int result1 = mapper.deleteWillopen(fundingCode);

        if(result1 != 0){
            message = "반려에 성공 하셨습니다.";
        } else{
            message = "반려에 실패 하셨습니다.";
        }

        return message;
    }


    @Override
    public String delete(String choiceValue) {



        // 삭제에 대한 결과
        int result1 = mapper.delete(choiceValue);

        if(result1 != 0) {
            return "성공적으로 삭제 되었습니다.";
        } else {
            throw new RuntimeException();
        }
    }



    // 신청한 펀딩 승인
    @Override
    public String insertFunding(ApprovedDTO approved) {

        String fundingTitle;
        String fundingCode;
        int result;
        String message = "";


        fundingTitle = approved.getFundingTitle();

        // 펀딩 코드
        fundingCode = mapper.selectFundingCode(fundingTitle);

        // 상태 리스트 추가
        result = mapper.insertFunding(fundingCode);

        System.out.println("result = " + result);

        if(result != 0){
            message = "승인에 성공하셨습니다";
        } else{
            throw new RuntimeException();
        }

        return message;
    }

    // 펀딩 반려
    @Override
    public String dropFunding(ApprovedDTO approved) {

        String fundingTitle;
        int fundingCode;
        int result;
        String message = "";


        fundingTitle = approved.getFundingTitle();

        // 펀딩 코드
        fundingCode = approved.getFundingCode();

        // 상태 리스트 추가
        result = mapper.dropFunding(fundingCode);

        System.out.println("result = " + result);

        if(result != 0){
            message = "반려에 성공하셨습니다";
        }  else{
            throw new RuntimeException();
        }


        return message;
    }

    @Override
    public String sellerDrop(String memberId) {

        // memberId로 memberCode를 찾는 코드
        String memberCode = mapper.selectMemberCode(memberId);

        int result;

        result = mapper.sellerDrop(memberCode);

        if(result != 0){
            return " 반려에 성공하셨습니다.";
        } else {
            throw new RuntimeException();
        }


    }

    @Override
    public int selectOngoingTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectOngoingTotalPage(searchMap);

        return result;
    }
}
