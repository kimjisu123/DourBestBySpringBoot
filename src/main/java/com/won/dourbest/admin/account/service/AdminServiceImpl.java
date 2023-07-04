package com.won.dourbest.admin.account.service;



import com.won.dourbest.admin.account.dao.AdminMapper;
import com.won.dourbest.admin.account.dto.*;
import com.won.dourbest.admin.common.SelectCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    // 매퍼 생성자
    private final AdminMapper mapper;
    public AdminServiceImpl(AdminMapper mapper) {
        this.mapper = mapper;

    }


    // 모든 회원 목록 조회
    @Override
    public List<AccountDTO> selectAllaccountList(SelectCriteria selectCriteria) {

        List<AccountDTO> accountList = mapper.selectAllaccountList(selectCriteria);

        for(int i =0; i <accountList.size(); i++){
            if(accountList.get(i).getSellerCode()!= null) {
                accountList.get(i).setSellerCode("Y");
            }
        }
        System.out.println("accountList.size() = " + accountList.size());
        return accountList;
    }

    // 탈퇴한 회원 조회
    @Override
    public List<withdrawnMemberDTO> selectAllwithdrawnList() {

        List<withdrawnMemberDTO> selectAllwithdrawnList = mapper.selectAllwithdrawnList();
        return selectAllwithdrawnList;
    }

    // 펀딩 결제 내역 조회
    @Override
    public List<FundingPaymentDTO> selectAllFunPaymentList() {

        List<FundingPaymentDTO> funPaymentList = mapper.selectAllFunPaymentList();

        return funPaymentList;
    }

    // 멤버십 결제 내역 조회
    @Override
    public List<MembershipPaymentDTO> selectAllmemPaymentList() {

        List<MembershipPaymentDTO> memPaymentList = mapper.selectAllmemPaymentList();


        return memPaymentList;
    }

    // 블랙리스트 조회
    @Override
    public List<BlcaklistDTO> selectallBlackList() {

        List<BlcaklistDTO> blcaklistList = mapper.selectallBlackList();

        return blcaklistList;
    }

    // 관리자 계정 조회
    @Override
    public List<AdminAccountDTO> selectAllAdminAccount() {

        List<AdminAccountDTO> adminAccountList = mapper.selectAllAdminAccount();

        return adminAccountList;
    }

    // 조건이 있을시 페이지의 갯수
    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int totalPage = mapper.selectTotalPage(searchMap);

        return totalPage;
    }

    // 관리자 계정 생성
    @Override
    public String registAdmin(AdminRegistDTO adminRegist) {

        // 중복되는 값이 있으면 result1, result2에 값이 들어온다.

        // 전화번호 중복체크
        String result1 = mapper.phoneRedundancy(adminRegist);
        // 이메일 중복체크
        String result2 = mapper.emailRedundancy(adminRegist);
        // 관리자 계정 생성 유무
        int result3 = mapper.registAdmin(adminRegist);

        String message = "";

        if(result1 == null){
            if(result2 == null){
                if(result3 != 0){
                    message = "회원가입이 성공하였습니다.";
                }else{
                    message = "회원가입이 실패하였습니다.";
                }
            }else{
                message = "중복되는 이메일이 있습니다.";
            }
        } else{
            message = "중복되는 전화번호가 있습니다.";
        }

        return message;
    }
}
