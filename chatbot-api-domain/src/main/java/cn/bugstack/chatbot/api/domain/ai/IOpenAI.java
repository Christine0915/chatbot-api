package cn.bugstack.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @description:chatGpt open ai 接口
 * @author：Chris
 * @date: 2023/10/25
 */
public interface IOpenAI {
    String doChatGpt(String question) throws IOException;
}
