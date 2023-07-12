package com.won.dourbest.seller.controller.jiho;

import com.won.dourbest.seller.dto.MainImgDTO;
import com.won.dourbest.seller.dto.beforeFundingDTO;
import com.won.dourbest.seller.service.jiho.BeforeFundingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/beforefunding")
public class BeforeFundingController {

    private final BeforeFundingService beforeFundingService;

    public BeforeFundingController(BeforeFundingService beforeFundingService) {
        this.beforeFundingService = beforeFundingService;
    }

    @GetMapping()
    public String beforeFunding(Model model) {

        Map<String, Object> imgMap = beforeFundingService.getImg();
        System.out.println("imgMap = " + imgMap);

        model.addAttribute("imgMap", imgMap);

        return "seller/funding/beforefunding";
    }
}
