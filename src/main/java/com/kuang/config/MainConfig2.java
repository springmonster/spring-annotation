package com.kuang.config;

import com.kuang.bean.Person;
import com.kuang.condition.LinuxCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@Conditional({LinuxCondition.class})
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
//    @Scope("prototype")
//    @Scope(scopeName = "singleton")
//    @Lazy
    @Bean(value = "person")
    public Person person() {
        System.out.println("this is new person");
        Person person = new Person();
        person.setName("kuang02");
        person.setAge(25);
        return person;
    }

    /**
     * 注解 @Conditional
     * 如果系统是Windows，则是Bill
     * 如果系统是Linux，则是Linus
     *
     * @return
     */
//    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person21() {
        return new Person(60, "比尔盖茨");
    }

    //    @Conditional({LinuxCondition.class})
    @Bean("Linus")
    public Person person22() {
        return new Person(50, "林纳斯");
    }
}
