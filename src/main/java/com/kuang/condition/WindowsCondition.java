package com.kuang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //        context.getBeanFactory(); 获取beanFactory
//        context.getClassLoader();
//        context.getRegistry();
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        return property != null && property.contains("Windows");
    }
}
