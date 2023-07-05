package com.won.dourbest.common.exception.user;

import javax.management.RuntimeMBeanException;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException() {}

    public EmailNotFoundException(String message) {
        super(message);
    }
}
