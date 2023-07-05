package com.won.dourbest.admin.account.dao;

import com.won.dourbest.admin.account.dto.AdminAccountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminMapperTest {


    @Autowired private AdminMapper mapper;
    @Test
    void findByAdmin() {
        AdminAccountDTO adminAccountDTO = mapper.findByAdmin("asdfaf@naver.coom").get();
        System.out.println("adminAccountDTO = " + adminAccountDTO);
    }
}