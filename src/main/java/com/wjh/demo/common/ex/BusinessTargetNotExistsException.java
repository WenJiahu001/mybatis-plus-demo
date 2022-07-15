package com.wjh.demo.common.ex;

public class BusinessTargetNotExistsException extends BusinessException {
    public BusinessTargetNotExistsException() {
        super("数据不存在");
    }
}