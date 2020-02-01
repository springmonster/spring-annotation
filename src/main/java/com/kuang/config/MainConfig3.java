package com.kuang.config;

import com.kuang.bean.Color;
import com.kuang.bean.ColorBeanFactory;
import com.kuang.bean.Person;
import com.kuang.bean.Red;
import com.kuang.selector.MyImportBeanDefinitionRegistrar;
import com.kuang.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * id是默认的全类名
 */
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig3 {

    @Bean(value = "personImport")
    public Person person() {
        return new Person(100, "import");
    }

    @Bean
    public ColorBeanFactory colorBeanFactory() {
        return new ColorBeanFactory();
    }
}
