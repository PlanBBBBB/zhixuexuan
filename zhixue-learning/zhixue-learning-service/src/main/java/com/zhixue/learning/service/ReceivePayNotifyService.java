package com.zhixue.learning.service;

import com.zhixue.messagesdk.model.po.MqMessage;

/**
 * 接收支付结果消息处理接口类
 */
public interface ReceivePayNotifyService {

    /**
     * 回复消息 <p>
     * 当学习中心服务处理完成后，向订单服务进行回复
     *
     * @param mqMessage 消息
     */
    void send(MqMessage mqMessage);

}
