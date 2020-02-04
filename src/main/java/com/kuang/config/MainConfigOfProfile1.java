package com.kuang.config;

import com.kuang.bean.MyDataSource;
import com.kuang.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import java.beans.PropertyVetoException;

/**
 *
 */
@Profile("prod")
@PropertySource(value = {"classpath:mydatasource.properties"})
@ComponentScan(value = {"com.kuang.bean"})
@Configuration
public class MainConfigOfProfile1 implements EmbeddedValueResolverAware {

    @Value("${db.name}")
    private String name;

    private String url;

    private String clazz;

    @Bean
    public Yellow yellow() {
        return new Yellow();
    }

    @Bean("testDataSource")
    public MyDataSource dataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setName(name);
        myDataSource.setPassword(password);
        myDataSource.setUrl(url);
        myDataSource.setClazz(clazz);
        return myDataSource;
    }

    @Bean("devDataSource")
    public MyDataSource dataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setPassword(password);
        myDataSource.setUrl(url);
        myDataSource.setClazz(clazz);
        return myDataSource;
    }

    @Bean("prodDataSource")
    public MyDataSource dataSourceProd(@Value("${db.password}") String password) throws PropertyVetoException {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setPassword(password);
        myDataSource.setUrl(url);
        myDataSource.setClazz(clazz);
        return myDataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        url = resolver.resolveStringValue("db.url");
        clazz = resolver.resolveStringValue("db.clazz");
    }
}
