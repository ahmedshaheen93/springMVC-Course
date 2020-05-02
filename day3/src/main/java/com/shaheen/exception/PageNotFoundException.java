package com.shaheen.exception;

import org.springframework.http.HttpStatus;

public class PageNotFoundException extends BaseException {

    public PageNotFoundException(String message) {
        super(message);
    }

    @Override
    protected HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

}
