package com.won.dourbest.admin.account.controller;

import com.won.dourbest.admin.account.dto.*;
import com.won.dourbest.admin.account.service.AdminServiceImpl;
import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AccountController {
    // 로그를 위한 객체
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AdminServiceImpl adminService;

    // 생성자 의존 주입
    public AccountController(AdminServiceImpl adminService) {

        this.adminService = adminService;
    }

    // 모든 회원 목록 조회
    @GetMapping("/admin")                                                                      // input hidden으로 넣어뒀던 현재 페이지
    public ModelAndView account(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO
                                ){

        Map<String, String> searchMap = new HashMap<>();
        System.out.println("searchId : " + searchId);
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = adminService.selectTotalPage(searchMap);
        System.out.println("totalPage = " + totalPage);
        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }

        log.info("selectCriteria : " + selectCriteria);

        List<AccountDTO> accountList = adminService.selectAllaccountList(selectCriteria);

        // 페이징 처리에 대한 데이터 값을 담고 있는 객체를 전송한다.
        mv.addObject("selectCriteria", selectCriteria);

        mv.addObject("accountList", accountList);
        mv.setViewName("admin/account/account");

        return mv;
    }

    // 탈퇴한 회원 조회
    @GetMapping("/withdrawn")
    public ModelAndView withdrawnMember (ModelAndView mv){



        List<withdrawnMemberDTO> withdrawnList = adminService.selectAllwithdrawnList();
        mv.addObject("withdrawnList" , withdrawnList);
        mv.setViewName("admin/account/withdrawnMember");
        return mv;
    }


    // 펀딩 결제 내역 조회
    @GetMapping("/funPayment")
    public ModelAndView fundingPayment(ModelAndView mv){

        List<FundingPaymentDTO> funPaymentList = adminService.selectAllFunPaymentList();

        mv.addObject("funPaymentList", funPaymentList);

        mv.setViewName("admin/account/fundingPayment");

        return mv;

    }



    // 멤버십 결제 내역
    @GetMapping("/memshipPayment")
    public ModelAndView membershipPayment(ModelAndView mv){

        List<MembershipPaymentDTO>  memPaymentList = adminService.selectAllmemPaymentList();

        mv.addObject("memPaymentList", memPaymentList);
        mv.setViewName("admin/account/membershipPayment");

        return mv;
    }



    // 블랙리스트 조회
    @GetMapping("/blackList")
    public ModelAndView blacklist(ModelAndView mv){

        List<BlcaklistDTO> blacklistList = adminService.selectallBlackList();

        mv.setViewName("admin/account/blackList");
        mv.addObject("blacklistList", blacklistList);

        log.info("blacklistList : " + blacklistList);

        return mv;
    }



    // 관리자 계정 조회
    @GetMapping("/adminAccount")
    public ModelAndView adminAccount(ModelAndView mv){

        List<AdminAccountDTO> adminAccountList = adminService.selectAllAdminAccount();

        mv.addObject("adminAccountList", adminAccountList);
        mv.setViewName("admin/account/adminAccount");

        return mv;
    }


}
