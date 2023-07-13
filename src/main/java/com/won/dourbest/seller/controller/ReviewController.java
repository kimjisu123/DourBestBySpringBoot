package com.won.dourbest.seller.controller;

import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.ReviewDTO;
import com.won.dourbest.seller.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/review/{fundingCode}")
    public ModelAndView review(ModelAndView mv, @RequestParam(required = false) String searchTitle
            , @RequestParam ( value="currentPage", defaultValue = "1") int pagNo, @PathVariable int fundingCode)   {

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





        List<ReviewDTO> review = service.selectReview(selectCriteria);

        mv.addObject("review", review);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("seller/giwon_seller/review");


        return mv;
    }
}
