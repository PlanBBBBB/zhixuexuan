package com.zhixue.checkcode.service.impl;

import com.zhixue.checkcode.service.CheckCodeService;

import java.util.Random;

/**
 * 数字生成器
 */
public class NumberCheckCodeGenerator implements CheckCodeService.CheckCodeGenerator {
    static final Random random = new Random();
    static final String str = "0123456789";

    @Override
    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
