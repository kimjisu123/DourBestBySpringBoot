package com.won.dourbest.common.global;

import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.exception.member.NoLoginException;
import com.won.dourbest.common.exception.user.CouponNotFoundException;
import com.won.dourbest.common.exception.user.ExistenceCreditException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<CommonResponse> CouponNotFound(CouponNotFoundException e){

        CommonResponse commonResponse = new CommonResponse()
                                            .builder()
                                            .message(e.getMessage())
                                            .isSuccess(false).build();

    return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(ExistenceCreditException.class)
    public  ResponseEntity<CommonResponse> ExistenceCredit(ExistenceCreditException e){
        CommonResponse commonResponse = new CommonResponse()
                                            .builder()
                                            .message(e.getMessage())
                                            .isSuccess(false).build();

        return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoLoginException.class)
    public String pleaseLogin(NoLoginException N) {
        return "user/login";
    }

}
