package com.won.dourbest.main.model.service;

import com.won.dourbest.user.dto.LikeFundingDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainServiceImplTest {

    @Autowired
    private MainService mainService;
    @Test
    void preOpenSlide() {
        List<LikeFundingDTO> f = mainService.preOpenSlide();
        System.out.println("f = " + f);
    }

    @Test
    void OpenSlide() {
        List<LikeFundingDTO> f = mainService.openSlide();
        System.out.println("f = " + f);
    }

}