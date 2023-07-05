package com.won.dourbest.user.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.exception.user.CreditException;
import com.won.dourbest.user.dto.MemberDTO;
import com.won.dourbest.user.dto.MemberImpl;
import com.won.dourbest.user.dto.MemberShipCreditDTO;
import com.won.dourbest.user.service.MemberService;
import com.won.dourbest.user.service.MemberShipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.HttpException;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/membership")
@RequiredArgsConstructor
public class MemberShipController {

    private final MemberService memberService;
    private final MemberShipService memberShipService;
    private final IamportClient iamportClient= new IamportClient("7526816782137126","fEkA4KEvTyRmGezJaob3MFV1WKTGCE4HIMZjWvd9niRctcOTtsUgawunwei8UFgp3xJfxaMymQczDONB");

    @GetMapping
    public String membership(Model model, @AuthenticationPrincipal MemberImpl member){

        if (member == null) return "/user/login";


        MemberDTO findMember = memberService.findUser(member.getMemberId()).orElseThrow();
        log.info("member={}",findMember);
        model.addAttribute("member",findMember);
        return "user/membership";

    }




    @PostMapping("/credit")
    @ResponseBody
    public void creditcheck(@RequestParam int memberCode){
        memberShipService.findByCredit(memberCode);
    }


    @ResponseBody
    @PostMapping("/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> verifyIamport(@PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {
        log.info("ididid={}",imp_uid);
        IamportResponse<Payment> paymentIamportResponse = iamportClient.paymentByImpUid(imp_uid);
        return iamportClient.paymentByImpUid(imp_uid);
    }


    @PostMapping(value = "/rank", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CommonResponse> memberShipUpdate(@RequestBody MemberShipCreditDTO memberShipCredit){

        log.info("memberShipCredit={}", memberShipCredit);
        Optional<MemberShipCreditDTO> result = memberShipService.memberShipChange(memberShipCredit);

        if(result.isEmpty()) throw new CreditException("결제정보 저장오류");

        CommonResponse resp = new CommonResponse(true,"결제정보가 정상 저장되었습니다.");
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
