package com.kuang;

import com.kuang.bean.Person;
import com.kuang.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) classPathXmlApplicationContext.getBean("person");
//        System.out.println(person);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(person);

        // 获取在Spring容器中Person.class的名称
        String[] namesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String s : namesForType) {
            System.out.println(s);
        }
    }
}
