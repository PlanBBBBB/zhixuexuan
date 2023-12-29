package com.zhixue;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.zhixue.*.feignclient"})
@SpringBootApplication
public class LearningTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearningTestApplication.class, args);
    }
}