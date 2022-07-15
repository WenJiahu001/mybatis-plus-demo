package com.wjh.demo.common;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -1L;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private int code;


    public BusinessException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public BusinessException(String message, int code) {
        this(message, HttpStatus.BAD_REQUEST, code);
    }


    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BusinessException(String message, HttpStatus httpStatus, int code) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}