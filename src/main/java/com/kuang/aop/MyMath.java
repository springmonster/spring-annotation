package com.kuang.aop;

import org.springframework.stereotype.Component;

@Component
public class MyMath {

    public int div(int i, int j) {
        int result = i / j;
        System.out.println("div result is " + result);
        return result;
    }
}
