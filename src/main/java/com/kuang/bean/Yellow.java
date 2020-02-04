package com.kuang.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:color.properties")
public class Yellow {

    @Value("${color.yellow}")
    private String color;

    @Override
    public String toString() {
        return "Yellow{" +
                "color='" + color + '\'' +
                '}';
    }
}
