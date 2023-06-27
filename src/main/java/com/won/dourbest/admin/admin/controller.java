package com.won.dourbest.admin.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping("/admin")
    public String adminController(){

        return "customerService/customerService";
    }


}
