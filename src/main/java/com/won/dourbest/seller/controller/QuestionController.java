package com.won.dourbest.seller.controller;

import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.QuestionDTO;
import com.won.dourbest.seller.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/funding/seller")
public class QuestionController {

    private final QuestionService service;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/question/{fundingCode}")
    public ModelAndView question(ModelAndView mv, @RequestParam(required = false) String searchTitle
                                       , @RequestParam ( value="currentPage", defaultValue = "1") int pagNo , @PathVariable int fundingCode) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchTitle", searchTitle);
        mv.addObject("fundingCode", fundingCode);

        int totalCount = service.selectTotalCount(searchMap);

        int limit = 10;

        int buttonAmount = 10;

        SelectCriteria selectCriteria = null;
        if(searchTitle != null && !"".equals(searchTitle)) {
            selectCriteria = Pagenation.getSelectCriteria(pagNo, totalCount, limit, buttonAmount, searchTitle);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pagNo, totalCount, limit, buttonAmount);
        }


        List<QuestionDTO> inquiry = service.selectQuestion(selectCriteria);

        System.out.println("selectCriteria : " + selectCriteria);

        mv.addObject("inquiry" , inquiry);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("seller/giwon_seller/question");


        return mv;
    }
}
