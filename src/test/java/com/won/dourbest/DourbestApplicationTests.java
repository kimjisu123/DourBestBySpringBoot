package com.won.dourbest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@Transactional
class DourbestApplicationTests {


    @Test
    void test() {
        Date today = new Date();
        System.out.println("today = " + today);
    }



}
