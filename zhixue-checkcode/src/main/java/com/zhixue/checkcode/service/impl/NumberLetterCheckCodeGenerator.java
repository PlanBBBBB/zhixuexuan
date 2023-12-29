package com.zhixue.checkcode.service.impl;

import com.zhixue.checkcode.service.CheckCodeService;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 数字字母生成器
 */
@Component("NumberLetterCheckCodeGenerator")
public class NumberLetterCheckCodeGenerator implements CheckCodeService.CheckCodeGenerator {

    @Override
    public String generate(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
