package com.kuang;

import com.kuang.config.TestConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestOfTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(TestConfig.class);
        String[] definitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }
}
