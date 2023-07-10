package com.won.dourbest.seller.controller.jiho;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dourbest")
public class SideController {

    @GetMapping("/notice")
    public String notice() {

        return "customerService/customerService";
    }

    @GetMapping("question")
    public String question() {

        return "";
    }

    @GetMapping("event")
    public String event() {

        return "";
    }
}
