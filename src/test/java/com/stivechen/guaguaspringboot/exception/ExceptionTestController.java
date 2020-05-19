package com.stivechen.guaguaspringboot.exception;

import com.stivechen.guaguaspringboot.common.exceptions.BadRequestException;
import com.stivechen.guaguaspringboot.common.exceptions.CommonCodeEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常测试类
 *
 * @author chenbingran
 */
@RestController
public class ExceptionTestController {

    @PostMapping("/exceptionTest")
    public void exceptionDemo(@RequestParam(value = "type", defaultValue = "biz") String type) throws Exception {

        if ("biz".equals(type)) {
            throw new BadRequestException(CommonCodeEnum.REQEST_TIMEOUT);

        } else if ("sys".equals(type)) {
            throw new Exception("系统异常");
        }
    }
}
