package com.won.dourbest.user.controller;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
//import com.won.dourbest.user.service.MemberServiceImpl;

import com.won.dourbest.user.service.MemberServiceImpl;
//import com.won.dourbest.user.service.UserDetailServiceImpl;
import com.won.dourbest.user.service.UserDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")   //기본페이지
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MemberServiceImpl service;
    private final PasswordEncoder passwordEncoder;

    private final UserDetailServiceImpl userDetail;




    // 의존성주입
    public MemberController(MemberServiceImpl service, PasswordEncoder passwordEncoder, UserDetailServiceImpl userDetail) {

        this.service = service;
        this.passwordEncoder = passwordEncoder;
        this.userDetail = userDetail;
    }



    // 회원가입페이지 이동 메소드
    @GetMapping("/signup")    //이동할 페이지
    public String signup(){

        return "user/signup";
    }

    @GetMapping("/login")    //이동할 페이지
    public String login(){

        return "user/login";
    }

    @GetMapping("/login/error")    //이동할 페이지
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "user/login";
    }



    @GetMapping("/findId")    //이동할 페이지
    public String findIdPage(){

        return "user/findId";
    }

    // 중복아이디 체크
    @PostMapping("checkId")
    @ResponseBody  //
    public String checkId(@RequestParam String memberId){
        System.out.println("memberId = " + memberId);
        String result = service.idCheck(memberId) == false? "success" : "fail";
        return result;
    }

    // 중복 이메일 체크
    @PostMapping("checkEmail")
    @ResponseBody  //
    public String checkEmail(@RequestParam String memberEmail){
        System.out.println("memberEmail = " + memberEmail);
        String result = service.emailCheck(memberEmail) == false? "success" : "fail";  // false면 중복값이 없으므로 success
        return result;
    }


//     회원 가입 페이지에서 값이 들어가는지 확인하는 메소드
    @PostMapping("/signup")
    public String signupMember(@ModelAttribute @Valid MemberDTO member, @ModelAttribute @Valid AddressDTO address, BindingResult bindingResult, HttpServletRequest request) {

        // DTO의 값을 받으면 컨트롤러에서 Map으로 전달 받은 후에  서비스로 전달을 해준다.
        Map<String, Object> map = new HashMap<>();
        member.setMemberPhone(member.getMemberPhone().replace("-", "").replace("+82","0"));  // +82 -> 0변경 하이픈제외
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));  // 비밀번호를 암호화해준다.
        map.put("member", member);
        map.put("address", address);
        service.registMember(map);


        // 회원가입이 성공하면 -> 회원에게 쿠폰을 insert 로 담아줘야한다.

        return "redirect:/category";  // 새롭게 주소를 요청한다 forward방식은  값을 계속 가지고 가기때문에
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,HttpServletRequest request) {

        System.out.println("memberId = " + username);
        System.out.println("memberPwd = " + password);
        log.info( "memberId" +username);
//        String result =  username;
//        userDetail.loadUserByUsername(result);
//
//        MemberDTO member = new MemberDTO();
//        member.setMemberId(username);
//        userDetail.loadUserByUsername(member.getMemberId());

        return "";

    }


}
