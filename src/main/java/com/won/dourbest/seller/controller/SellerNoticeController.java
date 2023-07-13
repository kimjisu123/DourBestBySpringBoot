package com.won.dourbest.seller.controller;

import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.SellerNoticeDTO;
import com.won.dourbest.seller.service.SellerNoticeService;
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
public class SellerNoticeController {

    private final SellerNoticeService service;

    public SellerNoticeController (SellerNoticeService service) {
        this.service = service;
    }

    @GetMapping("/notice/{fundingCode}")
    public ModelAndView notice(ModelAndView mv, @RequestParam(required = false) String searchTitle
            , @RequestParam ( value="currentPage", defaultValue = "1") int pagNo, @PathVariable int fundingCode ) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchTitle", searchTitle);
        mv.addObject("fundingCode", fundingCode);

        int totalCount = service.selectTotalCount(searchMap);

        int limit = 10;

        int buttonAmount = 10;
        System.out.println("fundingCode = " + fundingCode);
        System.out.println("pagNo = " + pagNo);


        SelectCriteria selectCriteria = null;
        if(searchTitle != null && !"".equals(searchTitle)) {
            selectCriteria = Pagenation.getSelectCriteria(pagNo, totalCount, limit, buttonAmount, searchTitle);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pagNo, totalCount, limit, buttonAmount);
        }


        List<SellerNoticeDTO> notice = service.selectNotice(selectCriteria);

        mv.addObject("notice" , notice);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("seller/giwon_seller/notice");

        return mv;
    }


}
