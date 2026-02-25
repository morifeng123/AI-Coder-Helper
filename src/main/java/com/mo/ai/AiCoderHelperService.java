package com.mo.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

public interface AiCoderHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat (String message);

}
