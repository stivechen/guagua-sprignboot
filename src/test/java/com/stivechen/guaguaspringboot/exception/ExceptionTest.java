package com.stivechen.guaguaspringboot.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 异常单元测试
 *
 * @author chenbingran
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void return_badRequestException_info() throws Exception {
        mockMvc.perform(post("/exceptionTest").param("type","biz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("400001"))
                .andExpect(jsonPath("$.msg").value("请求超时"));
    }

    @Test
    public void return_Exception_info() throws Exception {
        mockMvc.perform(post("/exceptionTest").param("type","sys"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("500000"))
                .andExpect(jsonPath("$.msg").value("系统异常"));
    }
}
