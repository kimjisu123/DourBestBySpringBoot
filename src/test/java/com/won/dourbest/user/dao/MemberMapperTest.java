package com.won.dourbest.user.dao;

import com.won.dourbest.user.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {


    @Autowired private MemberMapper mapper;

    @Test
    void findByMember() {

        String userId = "testuser";

        Optional<MemberDTO> byMember = mapper.findByMember(userId);
        System.out.println("byMember = " + byMember);

    }
}