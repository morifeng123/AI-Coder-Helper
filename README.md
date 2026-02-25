# AI Coder Helper

## 项目介绍

AI Coder Helper 是一个基于 Spring Boot 和 LangChain4j 开发的 AI 辅助编程工具，旨在帮助开发者通过与 AI 模型交互来提高编程效率。

## 技术栈

- **后端框架**: Spring Boot 3.5.0
- **Java 版本**: Java 21
- **AI 框架**: LangChain4j 1.1.0
- **AI 模型**: OpenAI (配置为 deepseek)
- **构建工具**: Maven
- **其他依赖**: Lombok


## 核心功能


## 开发说明


### 依赖说明

- **langchain4j-open-ai**: 提供与 OpenAI 模型交互的能力
- **langchain4j**: 核心 AI 框架
- **langchain4j-spring-boot-starter**: Spring Boot 集成
- **spring-boot-starter-web**: 提供 Web 服务能力

## 注意事项

1. **API 密钥安全**
   - 确保在 `application-local.yml` 文件中的 API 密钥不会被提交到版本控制系统
   - 建议使用环境变量或密钥管理服务来存储敏感信息

3. **性能优化**
   - 对于频繁的 AI 交互，考虑添加缓存机制
   - 监控 API 调用频率，避免超出 AI 服务提供商的限制


## 许可证

本项目采用 MIT 许可证。

## 联系方式

如有问题或建议，欢迎联系项目维护者。

## 知识点记录

### 1. Multimodal

在 LangChain4j 中，“多模态”（Multimodal） 指的是模型能够同时处理、理解或生成多种不同类型的数据流，而不仅仅是传统的纯文本。

**核心组成**：
- `TextContent`：用于处理文本数据的内容
- `ImageContent`：用于处理图像数据的内容
- `AudioContent`：用于处理音频数据的内容
- `VideoContent`：视频内容
- `PdfFileContent`: 用于处理 PDF 文件的内容

**使用示例**：
```java
UserMessage userMessage = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from("https://pic.rmb.bdstatic.com/bjh/251230/dump/c17400d248be707cbc4c591ae51b21a8.jpeg")
        );
ChatResponse chatResponse = deepseekChatModel.chat(userMessage);
AiMessage aiMessage = chatResponse.aiMessage();
return aiMessage.text();
```
