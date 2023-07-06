package com.won.dourbest.main.controller;

import com.won.dourbest.main.service.MainService;
import com.won.dourbest.user.dto.LikeFundingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public String mainPage(Model model){

        List<LikeFundingDTO> slideImages = mainService.getSlideImages();
        List<LikeFundingDTO> topLikeFunding = mainService.ToplikeFundings();
        List<LikeFundingDTO> openFundings = mainService.OpenFundings();
        List<LikeFundingDTO> endFundings = mainService.EndFundings();
        model.addAttribute("slideImages", slideImages);
        model.addAttribute("topLikeFunding", topLikeFunding);
        model.addAttribute("openFundings", openFundings);
        model.addAttribute("endFundings", endFundings);

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