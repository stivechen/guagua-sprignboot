package com.stivechen.guaguaspringboot.common.exceptions;

import com.stivechen.guaguaspringboot.core.exception.ResponseCodeEnum;

/**
 * 通用返回码枚举
 *
 * @author chenbingran
 */
public enum CommonCodeEnum implements ResponseCodeEnum {

    SUCCESS("200000", "成功"),
    REQEST_TIMEOUT("400001", "请求超时"),
    SYSTEM_ERROR("500000", "系统异常,请稍后重试");

    CommonCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
