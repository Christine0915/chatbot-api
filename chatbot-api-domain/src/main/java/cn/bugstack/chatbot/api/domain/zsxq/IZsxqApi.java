package cn.bugstack.chatbot.api.domain.zsxq;

import cn.bugstack.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @description:
 * @author：Chris
 * @date: 2023/10/24
 */
public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;
    /*
    silenced 是指时间线是否可见
     */
    boolean answer(String groupId, String cookie,String topicId,String text,boolean silenced) throws IOException;



}
