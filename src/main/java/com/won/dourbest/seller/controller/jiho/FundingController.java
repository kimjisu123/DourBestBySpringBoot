package com.won.dourbest.seller.controller.jiho;

import com.won.dourbest.seller.dto.FundingDTO;
import com.won.dourbest.seller.service.jiho.FundingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/funding")
@Slf4j
public class FundingController {

    private final FundingService fundingService;

    @Autowired
    public FundingController(FundingService fundingService) {
        this.fundingService = fundingService;
    }

    @GetMapping("/funding")
    public String funding(Model model) {

        Map<String, Object> map = fundingService.fundingPage();

        model.addAttribute("map", map);

        return "/seller/funding/funding";
    }
}
