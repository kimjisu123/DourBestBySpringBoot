package com.won.dourbest.admin.account.service;



import com.won.dourbest.admin.account.dao.AdminMapper;
import com.won.dourbest.admin.account.dto.*;
import com.won.dourbest.admin.common.SelectCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    // 매퍼 생성자
    private final AdminMapper mapper;

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
    public List<withdrawnMemberDTO> selectAllwithdrawnList(SelectCriteria selectCriteria) {

        List<withdrawnMemberDTO> selectAllwithdrawnList = mapper.selectAllwithdrawnList(selectCriteria);
        return selectAllwithdrawnList;
    }

    // 펀딩 결제 내역 조회
    @Override
    public List<FundingPaymentDTO> selectAllFunPaymentList(SelectCriteria selectCriteria) {

        List<FundingPaymentDTO> funPaymentList = mapper.selectAllFunPaymentList(selectCriteria);

        return funPaymentList;
    }

    // 멤버십 결제 내역 조회
    @Override
    public List<MembershipPaymentDTO> selectAllmemPaymentList(SelectCriteria selectCriteria) {

        List<MembershipPaymentDTO> memPaymentList = mapper.selectAllmemPaymentList(selectCriteria);


        return memPaymentList;
    }

    // 블랙리스트 조회
    @Override
    public List<BlcaklistDTO> selectallBlackList(SelectCriteria selectCriteria) {

        List<BlcaklistDTO> blcaklistList = mapper.selectallBlackList(selectCriteria);

        return blcaklistList;
    }

    // 관리자 계정 조회
    @Override
    public List<AdminAccountDTO> selectAllAdminAccount(SelectCriteria selectCriteria) {

        List<AdminAccountDTO> adminAccountList = mapper.selectAllAdminAccount(selectCriteria);

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
    @Transactional
    public String registAdmin(AdminRegistDTO adminRegist) {

        // 중복되는 값이 있으면 result1, result2에 값이 들어온다.


        String result1 = null;
        String result2 = null;
        int result3 = 0;
        int result4 = 0;

        // 전화번호가 입력시 중복체크
        result1 = mapper.phoneRedundancy(adminRegist);
        result2 = mapper.emailRedundancy(adminRegist);
        if(result1 != null){
            return "중복되는 전화번호가 있습니다.";
        }
        // 이메일이 입력시 중복체크
        if(result2 != null){
            return "중복되는 이메일이 있습니다.";
        }

        // 관리자 계정 생성 유무
        try {
            if(adminRegist.getAdminPassword() != null && adminRegist.getAdminEmail() != null &&
                    adminRegist.getAdminName() != null && adminRegist.getAdminPhone()  != null){
                result3 = mapper.registAdmin(adminRegist);

                if(result3 != 0){
                    // 권한 부여
                    result4 = mapper.insertAuth();
                    if(result4 != 0){
                        return "회원가입에 성공하셨습니다!";
                    }else{
                        throw new RuntimeException("회원가입에 실패하셨습니다");
                    }
                } else{
                    throw new RuntimeException("회원가입에 실패하셨습니다");
                }
            }
        } catch (RuntimeException e){
            throw new RuntimeException("회원가입에 실패하셨습니다.", e);
        }

        return "회원가입에 실패하셨습니다.";
    }

    // 회원 탈퇴
    @Override
    public String deleteMember(String memberId) {


        String result1;
        int result2;
        int result3;

        // 전송할 값
        String message ="";

        // 판매자인지 확인 (MEMBER_CODE 반환)
        result1 = mapper.selectSeller(memberId);
        // 이후 탈퇴
        result3 = mapper.deleteMember(memberId);

        // 판매자인지 확인
        if(result1 != null){
            // 판매자일 경우 판매자 권한 탈퇴(MEMBER_CODE로 값을 찾아 탈퇴)
            result2 = mapper.deleteSeller(result1);

            // 권한 탈퇴에 성공 했을 경우 회원 탈퇴
            if(result2 != 0){
                result3 = mapper.deleteMember(memberId);
            }
        } else{
            // 판매자가 아니라면 회원 탈퇴
            result3 = mapper.deleteMember(memberId);
        }

        if(result3 != 0){
            message = "회원 탈퇴에 성공하셨습니다.";
        } else {
            message = "회원 탈퇴에 실패하였습니다.";
        }

        return message;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //예외처리 추가해야함.
        AdminAccountDTO admin = mapper.findByAdmin(username).orElseThrow();

        List<AdminAuthListDTO> adminAuthList = admin.getAdminAuthList();
        List<GrantedAuthority> authorities = new ArrayList<>();
        adminAuthList.forEach(list -> authorities.add(new SimpleGrantedAuthority(list.getAdminAuth().getAuthName())));
        AdminImpl adminImpl = new AdminImpl(admin.getAdminEmail(), admin.getAdminPwd(), authorities);

        adminImpl.setDetail(admin);

        return adminImpl;
    }
}
