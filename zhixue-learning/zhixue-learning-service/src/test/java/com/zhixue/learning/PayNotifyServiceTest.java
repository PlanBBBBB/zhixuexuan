package com.zhixue.learning;

import com.zhixue.learning.service.ReceivePayNotifyService;
import com.zhixue.messagesdk.model.po.MqMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayNotifyServiceTest {

    @Autowired
    ReceivePayNotifyService receivePayNotifyService;

    @Test
    public void testSend() {
        MqMessage mqMessage = new MqMessage();
        mqMessage.setId(100L);
        receivePayNotifyService.send(mqMessage);
    }

}
