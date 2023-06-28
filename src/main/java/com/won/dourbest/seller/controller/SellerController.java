package com.won.dourbest.seller.controller;

import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.seller.service.SellerServiceImpl;
import com.won.dourbest.user.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/seller")
public class SellerController {


    private final SellerServiceImpl service;


    public SellerController (SellerServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/application")
    public String seller() {

        return "seller/giwon_seller/seller_application";
    }

    @PostMapping("/application")
    public String seller(HttpServletRequest request , @ModelAttribute SellerDTO seller ,@ModelAttribute MemberDTO member){


        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String license = request.getParameter("license");
        System.out.println("license : " + license);
        System.out.println(id);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);

        member.setMemberId(id);
        member.setMemberName(name);
        member.setMemberPhone(phone);
        member.setMemberEmail(email);
        seller.setBusinessLicense(license);


        service.registSeller(seller, member);



        return "seller/giwon_seller/seller_application";
    }

    @GetMapping("/success")
    public String success() {

        return "seller/giwon_seller/seller_success";
    }
}
