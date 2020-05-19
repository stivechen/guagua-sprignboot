package com.stivechen.guaguaspringboot.common.exceptions;

import com.stivechen.guaguaspringboot.core.exception.BizException;
import com.stivechen.guaguaspringboot.core.exception.ResponseCodeEnum;
import lombok.Data;

/**
 * 请求失败异常
 *
 * @author chenbingran
 */
@Data
public class BadRequestException extends BizException {

    public BadRequestException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BadRequestException(ResponseCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

}
