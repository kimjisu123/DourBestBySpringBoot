package com.won.dourbest.seller.controller;

import com.won.dourbest.seller.dto.QuestionDTO;
import com.won.dourbest.seller.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/question")
    public String question(Model model) {

        List<QuestionDTO> inquiry = service.selectQuestion();

        model.addAttribute("inquiry" , inquiry);


        return "seller/giwon_seller/question";
    }
}
