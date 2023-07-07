package com.won.dourbest.seller.controller;

import com.won.dourbest.seller.dto.ReviewDTO;
import com.won.dourbest.seller.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("seller")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("review")
    public String review(Model model) {

        List<ReviewDTO> review = service.selectReview();

        model.addAttribute("review", review);

        return "seller/giwon_seller/review";
    }
}
