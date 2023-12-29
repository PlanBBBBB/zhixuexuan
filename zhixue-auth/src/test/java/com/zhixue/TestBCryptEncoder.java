package com.zhixue;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "123";
        for (int i = 0; i < 10; i++) {
            String hashPass = encoder.encode(password);
            System.out.println("hashPass: " + hashPass);

            System.out.println(encoder.matches(password, hashPass));
        }
    }

}
