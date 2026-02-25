package com.mo.ai;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCoderHelperServiceTest {

    @Resource
    private AiCoderHelperService aiCoderHelperService;

    @Test
    void chat() {
        String result = aiCoderHelperService.chat("你好");
        System.out.println(result);
    }


}