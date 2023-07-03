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


}
