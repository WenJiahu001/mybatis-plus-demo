package com.wjh.demo.common;

public class BusinessTargetNotExistsException extends BusinessException {
    public BusinessTargetNotExistsException() {
        super("数据不存在");
    }
}