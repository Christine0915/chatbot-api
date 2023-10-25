package cn.bugstack.chatbot.api.domain.zsxq.model.aggregates;

import cn.bugstack.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * @description:
 * @author：Chris
 * @date: 2023/10/24
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;
    public boolean isSucceeded() {
        return succeeded;
    }
    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
