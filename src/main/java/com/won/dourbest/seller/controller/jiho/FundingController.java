package com.won.dourbest.seller.controller.jiho;

import com.won.dourbest.seller.service.jiho.FundingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{code}")
    public String funding(Model model, @PathVariable int code) {

        Map<String, Object> map = fundingService.fundingPage(code);

        System.out.println("map = " + map);
        model.addAttribute("tossMap", map);

        return "seller/funding/funding";
    }

}
