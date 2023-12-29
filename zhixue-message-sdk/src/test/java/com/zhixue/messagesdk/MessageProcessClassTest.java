package com.zhixue.messagesdk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
public class MessageProcessClassTest {

    @Autowired
    MessageProcessClass messageProcessClass;

    @Test
    public void test() {
        System.out.println("开始执行-----》" + LocalDateTime.now());
        messageProcessClass.process(0, 1, "test", 2, 10);

        System.out.println("结束执行-----》" + LocalDateTime.now());
    }
}
