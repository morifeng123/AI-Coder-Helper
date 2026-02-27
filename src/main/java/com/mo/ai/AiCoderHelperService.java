package com.mo.ai;

import com.mo.ai.guardrail.SafeInputGuardrail;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import java.util.List;


@InputGuardrails({SafeInputGuardrail.class})
public interface AiCoderHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat (String message);

    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport (String message);

    record Report(String name, List<String> suggestionList){}

    // 返回 RAG 封装后的结果
    @SystemMessage(fromResource = "system-prompt.txt")
    Result<String> chatWithRag (String message);

    @SystemMessage(fromResource = "system-prompt.txt")
    Flux<String> chatStream (@MemoryId int memoryId, @UserMessage String message);

}
