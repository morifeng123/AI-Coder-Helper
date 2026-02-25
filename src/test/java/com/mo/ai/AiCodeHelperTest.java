package com.mo.ai;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperTest {

    @Resource
    private AiCoderHelper aiCoderHelper;

    @Test
    void chat() {
        aiCoderHelper.chat("你好");
    }

    @Test
    void chatWithMessage() {
        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from("https://pic.rmb.bdstatic.com/bjh/251230/dump/c17400d248be707cbc4c591ae51b21a8.jpeg")
        );

        aiCoderHelper.chatWithMessage(userMessage);

    }

}
