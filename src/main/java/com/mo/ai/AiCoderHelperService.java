package com.mo.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

import java.util.List;

public interface AiCoderHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat (String message);

    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport (String message);

    record Report(String name, List<String> suggestionList){}

}
