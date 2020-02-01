package com.kuang;

import com.kuang.bean.Person;
import com.kuang.config.MainConfig;
import com.kuang.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] definitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//        for (String definitionName : definitionNames) {
//            System.out.println(definitionName);
//        }

        System.out.println("IOC 容器创建完成");
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println("IOC 容器创建完成");
        Person bean1 = annotationConfigApplicationContext.getBean(Person.class);
////        System.out.println(bean == bean1);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
