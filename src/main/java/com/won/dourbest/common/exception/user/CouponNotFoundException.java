package com.won.dourbest.common.exception.user;

public class CouponNotFoundException extends RuntimeException{

    public CouponNotFoundException() {}

    public CouponNotFoundException(String message) {
        super(message);
    }
}
