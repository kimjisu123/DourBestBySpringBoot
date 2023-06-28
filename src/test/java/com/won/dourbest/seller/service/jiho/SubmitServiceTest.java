package com.won.dourbest.seller.service.jiho;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SubmitServiceTest {

    @Autowired
    private SubmitService submitService;
    @Test
    void allPlan() {
    }

    @Test
    void insertTag() {

        submitService.insertTag(new String[]{"의류", "수영장"});

    }
}