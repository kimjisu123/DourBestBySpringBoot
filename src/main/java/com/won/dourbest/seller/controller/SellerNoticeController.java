package com.won.dourbest.seller.controller;

import com.won.dourbest.seller.dto.SellerNoticeDTO;
import com.won.dourbest.seller.service.SellerNoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seller")
public class SellerNoticeController {

    private final SellerNoticeService service;

    public SellerNoticeController (SellerNoticeService service) {
        this.service = service;
    }

    @GetMapping("/notice")
    public String notice(Model model) {

        List<SellerNoticeDTO> notice = service.selectNotice();

        model.addAttribute("notice" , notice);

        return "seller/giwon_seller/notice";
    }


}
