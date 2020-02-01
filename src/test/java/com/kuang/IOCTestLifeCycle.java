package com.kuang;

import com.kuang.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestLifeCycle {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC容器创建完成");

//        annotationConfigApplicationContext.getBean(Car.class);

        annotationConfigApplicationContext.close();
    }
}
