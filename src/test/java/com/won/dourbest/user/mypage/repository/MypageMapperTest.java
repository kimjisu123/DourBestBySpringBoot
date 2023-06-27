package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.user.dto.MypageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MypageMapperTest {

    @Autowired
    private MypageMapper mypageMapper;
    @Test
    void findById() {

        String userId = "user01";

        MypageDTO result = mypageMapper.findById(userId);

        log.info("resul={}", result);

    }
}