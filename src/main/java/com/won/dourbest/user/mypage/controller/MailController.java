package com.won.dourbest.user.mypage.controller;

import com.won.dourbest.user.dto.CheckMemberDTO;
import com.won.dourbest.user.mypage.service.MailService;
import com.won.dourbest.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {

    private final MailService mailService;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String mailForm(){
        return "/user/mypage/mailcheck";
    }

    @PostMapping("/check")
    @ResponseBody
    public String mailConfirm(@RequestParam String email, @RequestParam(required = false) String memberId) throws MessagingException {

        if(memberId == null ){
            return mailService.sendMail(email,"id");
        }

        String result = mailService.sendMail(email,"pwd");


        return result;
    }






}
