package com.stivechen.guaguaspringboot.common.exception;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用的返回消息实体类
 *
 * @author chenbingran
 */
@Data
public class ReturnInfo {
    private String msg;
    private String code;
    private String uri;

    public ReturnInfo(String msg, String code, String uri) {
        this.msg = msg;
        this.code = code;
        this.uri = uri;
    }

    public ReturnInfo(ResponseCodeEnum responseCodeEnum, String uri) {
        this.msg = responseCodeEnum.getMsg();
        this.code = responseCodeEnum.getCode();
        this.uri = uri;
    }


    /**
     * 业务失败信息处理
     *
     * @param req
     * @param e
     * @return
     */
    public static ReturnInfo bizError(HttpServletRequest req, BizException e) {
        if (null == e) {
            return new ReturnInfo(CommonCodeEnum.SYSTEM_ERROR, req.getRequestURI());
        }

        return new ReturnInfo(e.getMsg(), e.getCode(), req.getRequestURI());
    }


    /**
     * 系统异常信息处理
     *
     * @param req
     * @param e
     * @return
     */
    public static ReturnInfo error(HttpServletRequest req, BizException e) {
        if (null == e) {
            return new ReturnInfo(CommonCodeEnum.SYSTEM_ERROR, req.getRequestURI());
        }
        return new ReturnInfo(e.getMsg(), "500000", req.getRequestURI());
    }
}
