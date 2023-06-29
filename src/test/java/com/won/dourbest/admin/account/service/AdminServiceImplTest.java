package com.won.dourbest.admin.account.service;

import com.won.dourbest.admin.account.dto.AccountDTO;
import com.won.dourbest.admin.account.dto.FundingPaymentDTO;
import groovy.util.logging.Slf4j;
import oracle.jdbc.logging.annotations.Logging;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Test
    void selectllaccountList() {
        List<AccountDTO> result = adminService.selectAllaccountList();
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
    void selectAllAdminAccount() {
    }
}