package com.kuang;

import com.kuang.bean.Person;
import com.kuang.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTestPropertyValue {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

        Person bean = annotationConfigApplicationContext.getBean(Person.class);

        System.out.println(bean);

        ConfigurableEnvironment configurableEnvironment = annotationConfigApplicationContext.getEnvironment();
        String property = configurableEnvironment.getProperty("person.nickName");
        System.out.println(property);
    }
}
