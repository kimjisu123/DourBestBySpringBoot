package com.won.dourbest.user.login.conroller;

import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.user.dto.CheckMemberDTO;
import com.won.dourbest.user.login.model.service.MailService;
import com.won.dourbest.user.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        return "user/mypage/test";
    }

    @PostMapping("/check")
    @ResponseBody
    public String mailConfirm(@RequestParam String email, @RequestParam String memberId) throws MessagingException {

        String code = mailService.sendMail(email);

        int result = memberService.modifyMemberPwd(new CheckMemberDTO(memberId, passwordEncoder.encode(code)));

        if(result < 0) {
            //실패 예외 작성
        }

        return memberId;
    }



}
