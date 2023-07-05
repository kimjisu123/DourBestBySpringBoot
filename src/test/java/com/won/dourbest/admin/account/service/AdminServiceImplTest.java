package com.won.dourbest.admin.account.service;

import com.won.dourbest.admin.account.dto.AccountDTO;
import com.won.dourbest.admin.account.dto.FundingPaymentDTO;
import com.won.dourbest.admin.common.SelectCriteria;
import groovy.util.logging.Slf4j;
import oracle.jdbc.logging.annotations.Logging;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Test
    void selectllaccountList(SelectCriteria selectCriteria) {
        List<AccountDTO> result = adminService.selectAllaccountList(selectCriteria);
        System.out.println("result = " + result);
    }

    @Test
    void selectAllwithdrawnList() {
        
    }

    @Test
    void selectAllFunPaymentList() {

    }

    @Test
    void selectAllmemPaymentList() {
    }

    @Test
    void selectallBlackList() {
    }

    @Test
    void findByadmin() {
        UserDetails userDetails = adminService.loadUserByUsername("testAccount@gmail.com");

        System.out.println("userDetails.getAuthorities() = " + userDetails.getAuthorities());
    }
}