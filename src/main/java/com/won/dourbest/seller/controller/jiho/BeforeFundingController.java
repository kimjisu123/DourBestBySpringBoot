package com.won.dourbest.seller.controller.jiho;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beforefunding")
public class BeforeFundingController {

    @GetMapping()
    public String beforeFunding() {

        return "seller/funding/beforefunding";
    }
}
