package com.kuang.config;

import com.kuang.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@ComponentScan(value = "com.kuang.bean")
@Configuration
public class MainConfigOfLifeCycle {

    //    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
