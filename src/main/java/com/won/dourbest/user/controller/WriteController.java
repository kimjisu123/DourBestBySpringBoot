package com.won.dourbest.user.controller;

import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.exception.user.SellerInquireException;
import com.won.dourbest.seller.dto.ReviewDTO;
import com.won.dourbest.seller.dto.ReviewFileDTO;
import com.won.dourbest.seller.dto.SellerInquiryDTO;
import com.won.dourbest.user.dto.MemberImpl;
import com.won.dourbest.user.service.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/write")
@RequiredArgsConstructor
public class WriteController {

  private final WriteService writeService;

  @PostMapping("/seller")
  @ResponseBody
  public void sellerInquire(@AuthenticationPrincipal MemberImpl member, @ModelAttribute SellerInquiryDTO sellerInquiry){

    //3번 이상 질문했으면 너무많이했다고 리턴해버리자
    int count = writeService.contactCount(member.getUsername(), sellerInquiry.getFundingCode(), sellerInquiry.getCategoryCode());

    if(count > 3) throw new SellerInquireException("3번 이상 질문은 불가능합니다 답변을 기다려주세요!");

    writeService.saveSellerInquire(sellerInquiry);

    System.out.println("sellerInquiry = " + sellerInquiry);

  }

  @PostMapping("/review")
  @ResponseBody
  public void fundingReview(@AuthenticationPrincipal MemberImpl member, @RequestParam int memberCode, @RequestParam int reviewStar , @RequestParam(required = false) List<MultipartFile> uploadFile, @RequestParam int fundingCode, @RequestParam String content){

    ReviewDTO review = new ReviewDTO(0,member.getMemberName(), content.substring(0,9),content,null,"N",reviewStar,memberCode,fundingCode,null);

    // 리뷰저장
    writeService.saveReview(review);

    int reviewCode = review.getReviewCode();

    String root = "C:\\dev\\fundingImg\\";
    String reviewFilePath = root + "reviewImg";
    File mkdir = new File(reviewFilePath);

    if(!mkdir.exists()) {
      mkdir.mkdirs();
    }

    uploadFile.forEach((file)->{
        String originFileName = file.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-","") + ext;

      try {
        file.transferTo(new File(reviewFilePath + "\\" + savedName));
        //리뷰사진 저장
        ReviewFileDTO reviewFile = new ReviewFileDTO(0,originFileName,savedName,null,'N',reviewCode);
        writeService.saveReviewFile(reviewFile);

      } catch (IOException e) {
        new File(reviewFilePath + "\\" + savedName).delete();
      }


    });

  }

  @PostMapping("/review/{code}")
  @ResponseBody
  public void updatereview(@PathVariable int code, @AuthenticationPrincipal MemberImpl member, @RequestParam int memberCode, @RequestParam int reviewStar , @RequestParam(required = false) List<MultipartFile> uploadFile, @RequestParam int fundingCode, @RequestParam String content){

    ReviewDTO review = new ReviewDTO(code,member.getMemberName(), content.substring(0,9),content,null,"N",reviewStar,memberCode,fundingCode,null);

    // 리뷰수정
    writeService.reviewUpdate(review);

    String root = "C:\\dev\\fundingImg\\";
    String reviewFilePath = root + "reviewImg";
    File mkdir = new File(reviewFilePath);

    if(!mkdir.exists()) {
      mkdir.mkdirs();
    }

    uploadFile.forEach((file)->{
      String originFileName = file.getOriginalFilename();
      String ext = originFileName.substring(originFileName.lastIndexOf("."));
      String savedName = UUID.randomUUID().toString().replace("-","") + ext;

      try {
        file.transferTo(new File(reviewFilePath + "\\" + savedName));
        //리뷰사진 저장
        ReviewFileDTO reviewFile = new ReviewFileDTO(0,originFileName,savedName,null,'N',code);
        writeService.saveReviewFile(reviewFile);

      } catch (IOException e) {
        new File(reviewFilePath + "\\" + savedName).delete();
      }


    });

  }





  @GetMapping("/review/list")
  @ResponseBody
  public ReviewDTO reviewList(int reviewCode){

    ReviewDTO reviewDTO = writeService.reviewList(reviewCode);

    return reviewDTO;
  }


  @PostMapping("/review/file")
  @ResponseBody
  public void deleteFile(@RequestParam(value = "reviewFileCode[]",required = false) List<Integer> reviewFileCode){

    System.out.println("reviewFileCode = " + reviewFileCode);

    reviewFileCode.forEach((list)-> writeService.deleteFile(list));


  }



}
