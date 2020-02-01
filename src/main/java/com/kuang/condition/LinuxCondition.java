package com.kuang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /**
     * @param context  判断条件能使用的上下文环境
     * @param metadata 当前标注了注解的信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        context.getBeanFactory(); 获取beanFactory
//        context.getClassLoader();
//        context.getRegistry();
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        return property != null && property.contains("Linux");
    }
}
