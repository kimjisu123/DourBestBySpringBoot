package com.won.dourbest;

import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
import com.won.dourbest.user.service.MemberServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DourbestApplicationTests {

    @Autowired
    MemberServiceImpl service;
    @Test
    void contextLoads() {
    }
    private Mapper mapper;

    @Test
    @Transactional
    public void 회원가입_테스트() {
        Map<String, Object> map = new HashMap<>();
        MemberDTO member = new MemberDTO();
        AddressDTO address = new AddressDTO();

        member.setMemberCode(1);
        member.setMemberId("ma1");
        member.setMemberPwd("mama");
        member.setMemberName("ㅁㅁ");
        member.setMemberPhone("0100-11001-11");
        member.setMemberEmail("gg@gmail.com");
//        member.setRegistDate("23/12/12");
        member.setWithdrawalStatus('N');
        member.setAdultStatus('y');
//        member.setMembership(1);
//        address.getBaseAddress("서울특별시");

        map.put("member", member);
        map.put("address", address);
        service.registMember(map);
    }





}
