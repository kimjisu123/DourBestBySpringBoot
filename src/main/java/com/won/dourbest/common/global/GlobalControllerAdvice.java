package com.won.dourbest.common.global;

import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.exception.member.MemberRemoveException;
import com.won.dourbest.common.exception.member.NoLoginException;
import com.won.dourbest.common.exception.user.CouponNotFoundException;
import com.won.dourbest.common.exception.user.ExistenceCreditException;
import com.won.dourbest.common.exception.user.SellerInquireException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = {CouponNotFoundException.class,ExistenceCreditException.class, SellerInquireException.class })
    public ResponseEntity<CommonResponse> commonResponse(RuntimeException e){

        CommonResponse commonResponse = new CommonResponse()
                                            .builder()
                                            .message(e.getMessage())
                                            .isSuccess(false).build();

    return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoLoginException.class)
    public String pleaseLogin(NoLoginException e) {
        return "user/login";
    }

    @ExceptionHandler(MemberRemoveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String failRemove(MemberRemoveException e){

        return "/user/mypage/quitMemberFail";
    }

}
