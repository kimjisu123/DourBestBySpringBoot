package com.won.dourbest.user.mypage.controller;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.dto.Pagination;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.user.dto.*;
import com.won.dourbest.user.mypage.service.MypageCommonService;
import com.won.dourbest.user.mypage.service.MypageService;
import com.won.dourbest.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;

    private final MypageCommonService commonService;

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String mypage(Model model){

        /* 세션에서 멤버 가져와서 id 값을 이용하자 */
        String userId = "user01";

        MypageDTO mypageInfo = mypageService.myPageinfo(userId);

        model.addAttribute("mypageInfo", mypageInfo);

        return "user/mypage/mypage";
    }

    @GetMapping("/coupon")
    public String couponPage(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        /* 세션에서 멤버 가져와서 id 값을 이용하자 */
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "sellerInquire"));

        List<MemberCouponList> list = mypageService.allCoupon(criteria, userId);

        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/coupon";
    }

    @GetMapping("/seller-inquire")
    public String selleInquire(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "sellerInquire"));

        List<MemberSellerInquireDTO> list = mypageService.sellerInquire(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/sellerInquire";
    }

    @GetMapping("/inquire")
    public String adminInquire(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "adminInquire"));

        List<MemberInquireListDTO> list = mypageService.adminInquire(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/adminInquire";
    }

    @GetMapping("/report")
    public String reportList(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "report"));

        List<MemberReportListDTO> list = mypageService.reportList(criteria, userId);
        log.info("list={}", list);

        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/report";
    }


    @GetMapping("/like-funding")
    public String likeFundingList(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        //세션으로부터 받자
        String userId = "user01";

        Pagination pagination = new Pagination(criteria, mypageService.listTotalCount(criteria, userId, "like"));

        List<LikeFundingDTO> list = mypageService.likeFundingList(criteria, userId);
        log.info("list={}", list);
        List<CategoryDTO> category = commonService.fundingCategory();

        model.addAttribute("category", category);
        model.addAttribute("list", list);
        model.addAttribute("pagination", pagination);

        return "user/mypage/like";
    }

    @PostMapping(value = "/coupon/regist", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CommonResponse> couponRegist(@RequestBody MemberCouponList code){
        log.info("code={}", code);

        mypageService.couponRegister(code.getCouponListCode());

        CommonResponse response = new CommonResponse(true,"쿠폰등록성공");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 회원 정보
    @GetMapping("/current")
    public MemberDTO currentMember(@AuthenticationPrincipal MemberImpl member, Model model){
        MemberDTO findMember = memberService.findUser(member.getMemberId()).orElseThrow();
        log.info("member={}",findMember);
        model.addAttribute("member", member);
        return findMember;


    }

    // 회원 정보 변경
    @GetMapping("checkMember")
    public String checkmember(@AuthenticationPrincipal MemberImpl user, Model model) {

//        log.info("member={}",user);
//        log.info("memberid-{}", user.getMemberId());
//        log.info("userpwd={}", user.getPassword());
          model.addAttribute( "user", user );


        return "/user/mypage/checkMember";

    }


    // 회원정보 수정 전 로그인 체크
//    @PostMapping("checkMember")
//    @ResponseBody
//    public String infoModifytest(@AuthenticationPrincipal MemberImpl user, @RequestParam String pwd){
//
//        log.info("member={}",user);
//        log.info("memberid-{}", user.getMemberId());
//        log.info("userpwd={}", user.getPassword());
//        System.out.println("pwd = " + pwd);
//        log.info("pwd={}", pwd);
//        //확인완료
//        boolean result = passwordEncoder.matches(pwd , user.getPassword());
//        log.info("result={}",result);
//        memberService.findUser(user.getMemberId());
//
//            return  "redirect:user/mypage/changeInfo";
//
//
//
//        }

    @PostMapping("checkMember")
    @ResponseBody
    public String checkMember(@AuthenticationPrincipal MemberImpl user,@RequestParam String pwd){

        log.info("pwd = " +  pwd);
        System.out.println("pwd = " +  pwd);

        boolean result = passwordEncoder.matches( pwd , user.getPassword());  // false면 중복값이 없으므로 success


        if(result) {

            return "redirect:user/mypage/changeInfo;

        } else {


        }

        // 맞으면 true
    }






    @GetMapping("changeInfo")
    public String changeInfo(){

        return "user/mypage/changeInfo";

    }
//   회원정보 수정
    @PostMapping ("changeInfo")
    public String changeInfo (@ModelAttribute MemberDTO member, @ModelAttribute AddressDTO address, Model model){


        Map<String, Object> map = new HashMap<>();
        member.setMemberPhone(member.getMemberPhone().replace("-", "").replace("+82","0"));  // +82 -> 0변경 하이픈제외
        map.put("member", member);
        map.put("address", address);
        memberService.modifiyMember(map);


        return "redirect:user/mypage/changeInfo";

    }



}
