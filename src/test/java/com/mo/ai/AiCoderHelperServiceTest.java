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

    @Test
    void chatWithMemory() {
        String result = aiCoderHelperService.chat("你好,我是枫");
        System.out.println(result);
        result = aiCoderHelperService.chat("你知道我是谁吗？");
        System.out.println(result);
    }


    @Test
    void chatForReport() {
        String userMessage = "你好，我是枫，请你帮我制定AI的的学习路线";
        AiCoderHelperService.Report report = aiCoderHelperService.chatForReport(userMessage);
        System.out.println(report);
    }
}