package com.won.dourbest.common.exception.member;

public class MailNotFoundException extends RuntimeException{

    public MailNotFoundException() {
        super();
    }

    public MailNotFoundException(String message) {
        super(message);
    }
}
