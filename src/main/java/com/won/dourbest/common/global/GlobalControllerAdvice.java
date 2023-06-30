package com.won.dourbest.common.global;

import com.won.dourbest.common.dto.CommonResponse;
import com.won.dourbest.common.exception.user.CouponNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CouponNotFoundException.class)
    public String CouponNotFound(CouponNotFoundException e){


    return "";
//        return new ResponseEntity<CommonResponse>("우아아앋아");
    }


}
