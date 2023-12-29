package com.zhixue.orders.jobhandler;

import com.alibaba.fastjson.JSON;
import com.zhixue.messagesdk.model.po.MqMessage;
import com.zhixue.messagesdk.service.MessageProcessAbstract;
import com.zhixue.messagesdk.service.MqMessageService;
import com.zhixue.orders.config.PayNotifyConfig;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付通知任务
 */
@Slf4j
@Component
public class PayNotifyTask extends MessageProcessAbstract {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MqMessageService mqMessageService;


    // 任务调度入口
    @XxlJob("NotifyPayResultJobHandler")
    public void notifyPayResultJobHandler() throws Exception {
        // 分片参数
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();
        log.debug("shardIndex=" + shardIndex + ",shardTotal=" + shardTotal);
        // 只查询支付通知的消息
        process(shardIndex, shardTotal, PayNotifyConfig.MESSAGE_TYPE, 100, 60);
    }

    // 执行任务的具体方法
    @Override
    public boolean execute(MqMessage mqMessage) {
        log.debug("向消息队列发送支付结果通知消息：{}", mqMessage);
        // 发布消息
        send(mqMessage);
        return false;
    }


    /**
     * 接收回复 <p>
     * 监听支付结果通过回复队列
     *
     * @param message 消息内容
     */
    @RabbitListener(queues = PayNotifyConfig.PAYNOTIFY_REPLY_QUEUE)
    public void receive(String message) {
        log.debug("收到支付结果通知回复：{}", message);
        MqMessage mqMessage = JSON.parseObject(message, MqMessage.class);
        // 完成消息发送，最终该消息删除了
        mqMessageService.completed(mqMessage.getId());
    }


    /**
     * 发送支付结果通知
     *
     * @param message 消息内容
     * @author Wuxy
     * @since 2022/9/20 9:43
     */
    private void send(MqMessage message) {
        // 要发送的消息
        String jsonStringMsg = JSON.toJSONString(message);

        // 开始发送消息,使用 fanout 交换机，通过广播模式发送消息
        rabbitTemplate.convertAndSend(PayNotifyConfig.PAYNOTIFY_EXCHANGE_FANOUT, "", jsonStringMsg);

        log.debug("向消息队列发送支付结果通知消息完成：{}", message);
    }
}
