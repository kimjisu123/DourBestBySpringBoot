package com.won.dourbest.common.exception.member;

public class NoLoginException extends RuntimeException{

    public NoLoginException() {
    }

    public NoLoginException(String message) {
        super(message);
    }
}
