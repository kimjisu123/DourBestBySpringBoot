package com.won.dourbest.main.controller;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.common.dto.Pagination;
import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.main.model.dto.CategoryFundingDTO;
import com.won.dourbest.main.model.service.MainService;
import com.won.dourbest.user.mypage.service.MypageCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    private final MypageCommonService commonService;


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
    public String categoryList(@ModelAttribute("cri") SearchCriteria criteria, Model model){

        Pagination pagination = new Pagination(criteria, mainService.totalCount(criteria));

        List<CategoryFundingDTO> list = mainService.categoryList(criteria);

        List<CategoryDTO> category = commonService.fundingCategory();

        model.addAttribute("category",category);
        model.addAttribute("list",list);
        model.addAttribute("pagination",pagination);

        return "/main/category-page";
    }



}