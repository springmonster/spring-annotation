package com.kuang.config;

import com.kuang.aop.MathAspect;
import com.kuang.aop.MyMath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类=配置文件
 * 告诉Spring这是一个配置类
 * excludeFilters： 扫描的时候排除哪些
 * includeFilters： 扫描的时候只扫描哪些
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MyMath myMath() {
        return new MyMath();
    }

    @Bean
    public MathAspect mathAspect() {
        return new MathAspect();
    }
}
