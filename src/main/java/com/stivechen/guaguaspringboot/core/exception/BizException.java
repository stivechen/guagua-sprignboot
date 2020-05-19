package com.stivechen.guaguaspringboot.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常基础类抽象类
 *
 * @author chenbingran
 */
@Getter
@Setter
public abstract class BizException extends RuntimeException {

    protected String code;

    protected String msg;
}
