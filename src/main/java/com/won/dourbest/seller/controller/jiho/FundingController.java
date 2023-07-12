package com.won.dourbest.seller.controller.jiho;

import com.won.dourbest.common.exception.member.NoLoginException;
import com.won.dourbest.seller.service.jiho.FundingService;
import com.won.dourbest.user.dto.MemberImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/funding")
@Slf4j
public class FundingController {

    private final FundingService fundingService;

    @Autowired
    public FundingController(FundingService fundingService) {
        this.fundingService = fundingService;
    }

    @GetMapping("/{code}")
    public String funding(Model model, @PathVariable int code, @AuthenticationPrincipal MemberImpl member) {

        Map<String, Object> map = fundingService.fundingPage(code);

        int result= 0;
        int result1 = 0;

        if(member == null) {
            result = -1;
        } else {
            int memberCode = member.getMemberCode();
            result = fundingService.selectLikes(code, memberCode);
            result1 = fundingService.selectReport(code, memberCode);
        }

        model.addAttribute("result", result);
        model.addAttribute("result1", result1);
        System.out.println("result1 = " + result1);
        System.out.println("map = " + map);
        model.addAttribute("tossMap", map);
        System.out.println("code = " + code);
        model.addAttribute("fundingCode", code);

        return "seller/funding/funding";
    }

    @GetMapping("/buy/{optionCode}")
    public String buyOption(Model model, @PathVariable int optionCode, @AuthenticationPrincipal MemberImpl member) {



        if(member == null) {
            throw new NoLoginException("로그인이 안되어있음");
        }

        System.out.println("컨트롤러 진입함");
        System.out.println("optionCode = " + optionCode);

        model.addAttribute("optionCode",optionCode);

        return "/seller/giwon_seller/payment_page";
    }

    @PostMapping("/likes")
    @ResponseBody
    public String likes(@RequestParam int fundingCode, @AuthenticationPrincipal MemberImpl member) {

        System.out.println("member = " + member);
        int num = 0;
        String result = "";
        if(member == null) {
            throw new NoLoginException("로그인이 안되어있음");
        } else {
            int memberCode = member.getMemberCode();
            num = fundingService.addLikes(fundingCode, memberCode);
        }

        if(num == 1) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

    @PostMapping("/noLikes")
    @ResponseBody
    public String noLikes(@RequestParam int fundingCode, @AuthenticationPrincipal MemberImpl member) {

        System.out.println("member = " + member);
        int num = 0;
        String result = "";
        if(member == null) {
            throw new NoLoginException("로그인이 안되어있음");

        } else {
            int memberCode = member.getMemberCode();
            num = fundingService.deleteLikes(fundingCode, memberCode);
        }

        if(num == 1) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

    @GetMapping("/user/login")    //이동할 페이지
    public String login(){

        return "user/login";
    }

    @GetMapping("/notice/{code}")
    public String notice(Model model, @PathVariable int code) {

        model.addAttribute("fundingCode", code);

        return "/seller/giwon_seller/notice";
    }

    @GetMapping("/question/{code}")
    public String question(Model model, @PathVariable int code) {

        model.addAttribute("fundingCode", code);

        return "/seller/giwon_seller/question";
    }

    @GetMapping("/review/{code}")
    public String review(Model model, @PathVariable int code) {

        model.addAttribute("fundingCode", code);

        return "/seller/giwon_seller/review";
    }

    @PostMapping("/report")
    @ResponseBody
    public String report(@RequestParam String category, @RequestParam String title
            , @RequestParam String content, @RequestParam int fundingCode
            , @AuthenticationPrincipal MemberImpl member) {

        String message = "";

        if(member != null) {
            int memberCode = member.getMemberCode();
            Map<String, Object> map = new HashMap<>();
            map.put("memberCode", memberCode);
            map.put("category", category);
            map.put("title", title);
            map.put("content", content);
            map.put("fundingCode", fundingCode);

            message = fundingService.insertReport(map);
        } else {
            throw new NoLoginException("로그인이 안되어있음");
        }

        return message;
    }
}
