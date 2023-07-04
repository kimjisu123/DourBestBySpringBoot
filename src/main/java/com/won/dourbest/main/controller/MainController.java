package com.won.dourbest.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String mainPage(){
        return "/main/main";
    }
    @PostMapping("/")
    public String defaultLocation(){
        return "redirect:/";
    }

    @GetMapping("/category")
    public String categoryList(){
        return "/main/category-page";
    }



}