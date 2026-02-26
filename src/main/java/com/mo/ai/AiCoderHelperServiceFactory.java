package com.mo.ai;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.spring.AiService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCoderHelperServiceFactory {

    @Resource
    private ChatModel deepseekChatModel;

    @Bean
    public AiCoderHelperService aiCoderHelperService() {

        // 会话记忆
        MessageWindowChatMemory ChatMemory = MessageWindowChatMemory.withMaxMessages(10);

        AiCoderHelperService aiCoderHelperService = AiServices.builder(AiCoderHelperService.class)
                .chatModel(deepseekChatModel)
                .chatMemory(ChatMemory)
                .build();

        return aiCoderHelperService;
    }


}
