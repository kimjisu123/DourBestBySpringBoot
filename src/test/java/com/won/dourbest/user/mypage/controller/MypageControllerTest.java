package com.won.dourbest.user.mypage.controller;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
import com.won.dourbest.user.mypage.service.MypageCommonService;
import com.won.dourbest.user.mypage.service.MypageService;
import com.won.dourbest.user.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@SpringBootTest
public class MypageControllerTest {

    @Autowired
    private  MypageService mypageService;

    @Autowired
    private  MemberService memberService;

    @Test
    void changeInfo (@ModelAttribute MemberDTO member, @ModelAttribute AddressDTO address){

        log.info("MemberDTO : ",member.toString());
        log.info("AddressDTO : ",address.toString());

    }


}
