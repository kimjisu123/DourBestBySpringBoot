package com.won.dourbest.user.controller;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
//import com.won.dourbest.user.service.MemberServiceImpl;

import com.won.dourbest.user.service.MemberServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")   //기본페이지
public class MemberController {

    private final MemberServiceImpl service;



    // 의존성주입
    public MemberController(MemberServiceImpl service) {
        this.service = service;
    }



    // 회원가입페이지 이동 메소드
    @GetMapping("/signup")    //이동할 페이지
    public String signup(){

        return "user/signup";
    }


//     회원 가입 페이지에서 값이 들어가는지 확인하는 메소드
    @PostMapping("/signup")
    public String signupMember(@ModelAttribute MemberDTO member, @ModelAttribute AddressDTO address, HttpServletRequest request) {

//        System.out.println("member = " + member);
//        System.out.println("address = " + address);
        // DTO의 값을 받으면 컨트롤러에서 Map으로 전달 받은 후에  서비스로 전달을 해준다.
        Map<String, Object> map = new HashMap<>();
        map.put("member", member);
        map.put("address", address);
        service.registMember(map);

        return "";
    }



}
