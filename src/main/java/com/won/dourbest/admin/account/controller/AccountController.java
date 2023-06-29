package com.won.dourbest.admin.account.controller;

import com.won.dourbest.admin.account.dto.*;
import com.won.dourbest.admin.account.service.AdminServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AdminServiceImpl adminService;
    public AccountController(AdminServiceImpl adminService) {

        this.adminService = adminService;
    }

    // 모든 회원 목록 조회
    @GetMapping("/admin")
    public ModelAndView account(ModelAndView mv, @RequestParam(defaultValue = "1") int page){


        List<AccountDTO> accountList = adminService.selectAllaccountList();

        mv.addObject("accountList", accountList);

        mv.setViewName("admin/account/account");

        return mv;
    }

    // 탈퇴한 회원 조회
    @GetMapping("/withdrawn")
    public ModelAndView withdrawnMember (ModelAndView mv){

        List<withdrawnMemberDTO> withdrawnList = adminService.selectAllwithdrawnList();

        mv.addObject("withdrawnList", withdrawnList);

        mv.setViewName("admin/account/withdrawnMember");

        return mv;
    }


    // 펀딩 결제 내역 조회
    @GetMapping("/funPayment")
    public String fundingPayment(Model model){

        List<FundingPaymentDTO> funPaymentList = adminService.selectAllFunPaymentList();

        model.addAttribute("funPaymentList", funPaymentList);

        return "admin/account/fundingPayment";

    }



    // 멤버십 결제 내역
    @GetMapping("/memshipPayment")
    public String membershipPayment(Model model){

        List<MembershipPaymentDTO>  memPaymentList = adminService.selectAllmemPaymentList();

        model.addAttribute("memPaymentList", memPaymentList);

        return "admin/account/membershipPayment";
    }



    // 블랙리스트 조회
    @GetMapping("/blackList")
    public String blacklist(Model model){

        List<BlcaklistDTO> blcaklistList = adminService.selectallBlackList();

        model.addAttribute("blacklistList", blcaklistList);

        return "admin/account/blackList";
    }



    // 관리자 계정 조회
    @GetMapping("/adminAccount")
    public String adminAccount(Model model){

        List<AdminAccountDTO> adminAccountList = adminService.selectAllAdminAccount();

        model.addAttribute("adminAccountList", adminAccountList);

        return "admin/account/adminAccount";
    }


}
