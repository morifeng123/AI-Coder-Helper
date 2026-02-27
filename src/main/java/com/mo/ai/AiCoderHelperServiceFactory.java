package com.mo.ai;

import com.mo.ai.mcp.McpConfig;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.spring.AiService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCoderHelperServiceFactory {

    @Resource
    private ChatModel deepseekChatModel;

    @Resource
    private ContentRetriever contentRetriever;

    @Resource
    private McpToolProvider mcpToolProvider;

    @Resource
    private StreamingChatModel deepseekStreamingChatModel;

    @Bean
    public AiCoderHelperService aiCoderHelperService() {

        // 会话记忆
        MessageWindowChatMemory ChatMemory = MessageWindowChatMemory.withMaxMessages(10);

        AiCoderHelperService aiCoderHelperService = AiServices.builder(AiCoderHelperService.class)
                .chatModel(deepseekChatModel)
                .streamingChatModel(deepseekStreamingChatModel) // 流式输出
                .chatMemory(ChatMemory)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10)) // 会话记忆
//                .contentRetriever(contentRetriever)  // RAG 检索增强生成  免费token用完了
//                .toolProvider(mcpToolProvider) // mcp 工具调用
                .build();

        return aiCoderHelperService;
    }


}
