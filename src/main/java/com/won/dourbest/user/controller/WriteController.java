package com.won.dourbest.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/write")
public class WriteController {

  @PostMapping("/seller")
  @ResponseBody
  public void sellerInquire(@RequestParam String option, @RequestParam(required = false) List<MultipartFile> uploadFile, @RequestParam int funding, @RequestParam String content){

    //3번 이상 질문했으면 너무많이했다고 리턴해버리자
    
    System.out.println("option = " + option);
    System.out.println("uploadFile = " + uploadFile);


  }

  @PostMapping("/review")
  @ResponseBody
  public void fundingReview(@RequestParam int reviewStar , @RequestParam(required = false) List<MultipartFile> uploadFile, @RequestParam int funding, @RequestParam String content){

    // 리뷰 있으면 작성못하게 유효성 추가 필요
    
    System.out.println("reviewStar = " + reviewStar);
    System.out.println("content = " + content);
    uploadFile.forEach((i)-> System.out.println("i.getOriginalFilename() = " + i.getOriginalFilename()));


  }

}
