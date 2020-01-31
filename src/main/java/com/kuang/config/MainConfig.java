package com.kuang.config;

import com.kuang.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

/**
 * 配置类=配置文件
 * 告诉Spring这是一个配置类
 * excludeFilters： 扫描的时候排除哪些
 * includeFilters： 扫描的时候只扫描哪些
 */
@Configuration
//@ComponentScan(value = "com.kuang", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})})
//@ComponentScan(value = "com.kuang", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
//        Controller.class
//})}, useDefaultFilters = false)
@ComponentScans(value = {@ComponentScan(value = "com.kuang", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})})})
public class MainConfig {

    /**
     * 给容器中注册一个Bean，类型为返回值的类型，id默认是方法名作为id
     * 想要改变名称有两种方式
     * 1. 改变方法的名字，例如person()变为person01()
     * 2. 给Bean加value
     *
     * @return
     */
    @Bean(value = "person01")
    public Person person() {
        Person person = new Person();
        person.setName("KuangAnno");
        person.setAge(30);
        return person;
    }
}
