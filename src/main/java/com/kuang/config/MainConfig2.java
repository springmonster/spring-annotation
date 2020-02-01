package com.kuang.config;

import com.kuang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class MainConfig2 {

    /**
     * 默认是但实例的
     * prototype 多实例的
     * singleton 单实例的（默认值） IOC容器启动会调用方法创建对象放到IOC容器中，以后每次获取就是直接从容器中拿，享元？？？
     * request 同一个请求创建一个实例
     * session 同一个session创建一个实例
     *
     * @return
     */
    @Scope("prototype")
//    @Scope(scopeName = "singleton")
    @Bean(value = "person")
    public Person person() {
        System.out.println("this is before new person");
        Person person = new Person();
        person.setName("kuang02");
        person.setAge(25);
        return person;
    }
}
