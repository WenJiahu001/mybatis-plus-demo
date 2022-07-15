package com.wjh.demo.common.ex;

import com.wjh.demo.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * 统一异常拦截
 *
 * @author wjh
 * @since 2022-07-15
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public R handleJeecgBootException(BusinessException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error(404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }


    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error("操作失败，" + e.getMessage());
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        StringBuffer sb = new StringBuffer();
        sb.append("不支持");
        sb.append(e.getMethod());
        sb.append("请求方法，");
        sb.append("支持以下");
        String[] methods = e.getSupportedMethods();
        if (methods != null) {
            for (String str : methods) {
                sb.append(str);
                sb.append("、");
            }
        }
        log.error(sb.toString(), e);
        return R.error(405, sb.toString());
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public R handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage(), e);
        return R.error("字段太长,超出数据库字段的长度");
    }


}
