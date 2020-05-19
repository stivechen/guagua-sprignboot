package com.stivechen.guaguaspringboot.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author chenbingran
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public ReturnInfo bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("GlobalExceptionHandler bizExceptionHandler code:[{}] msg:[{}]", e.getCode(), e.getMsg());
        return ReturnInfo.bizError(req, e);
    }


    /**
     * 系统异常处理
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ReturnInfo sysExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("GlobalExceptionHandler sysExceptionHandler msg:[{}]", e.getMessage());
        return ReturnInfo.error(req, e);
    }

}
