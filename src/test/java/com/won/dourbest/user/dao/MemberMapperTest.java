package com.won.dourbest.user.dao;

import com.won.dourbest.user.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {


    @Autowired private MemberMapper mapper;
    @Autowired private PasswordEncoder passwordEncoder;

    @Test
    void findByMember() {

        String userId = "testuser";

        Optional<MemberDTO> byMember = mapper.findByMember(userId);
        System.out.println("byMember = " + byMember);
    }

    @Test
    void find() {

        String userId = "testuser";
        String pwd = "qwerasdf!!";
        String pwd2 = "iYk6786w";

        Optional<MemberDTO> byMember = mapper.findByMember(userId);

        String memberPwd = byMember.get().getMemberPwd();
        boolean result = passwordEncoder.matches(pwd, memberPwd);
        boolean result2 = passwordEncoder.matches(pwd2, memberPwd) ;
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);


        System.out.println("byMember = " + byMember);

    }

    @Test
    @Transactional
    void fff() {

        MemberDTO member = new MemberDTO();
        member.setMemberId("asdfdfeef");
        member.setMemberPwd("asdfasdf!!");
        member.setMemberPhone("01010101010");
        member.setMemberName("dndkdkdkdk");
        member.setMemberEmail("dsfddd@dd.com");
        Map<String, Object> map = new HashMap<>();
        map.put("member",member);

        mapper.registMember(map);

        System.out.println("member.getMemberCode() = " + member.getMemberCode());

    }







}