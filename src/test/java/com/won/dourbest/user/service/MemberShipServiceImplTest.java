package com.won.dourbest.user.service;

import com.won.dourbest.user.dao.MemberShipMapper;
import com.won.dourbest.user.dto.MemberShipCreditDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberShipServiceImplTest {

    @Autowired private MemberShipMapper memberShipMapper;
    @Autowired private MemberShipService memberShipService;

    @Test
    void findByCredit() {

        Optional<MemberShipCreditDTO> byCredit = memberShipService.findByCredit(53);

        System.out.println("byCredit = " + byCredit);


    }
}