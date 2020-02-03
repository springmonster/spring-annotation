package com.kuang.config;

import com.kuang.bean.Car;
import com.kuang.bean.Color;
import com.kuang.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 */
@ComponentScan(value = {"com.kuang.controller", "com.kuang.service", "com.kuang.dao", "com.kuang.bean"})
@Configuration
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    /**
     * @return
     */
    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
