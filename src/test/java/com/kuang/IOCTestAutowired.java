package com.kuang;

import com.kuang.bean.Boss;
import com.kuang.bean.Car;
import com.kuang.bean.Color;
import com.kuang.config.MainConfigOfAutowired;
import com.kuang.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestAutowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = annotationConfigApplicationContext.getBean(BookService.class);
        bookService.print();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        Boss boss = annotationConfigApplicationContext.getBean(Boss.class);
        Car car = annotationConfigApplicationContext.getBean(Car.class);
        System.out.println(boss);
        System.out.println(car);

        Color color = annotationConfigApplicationContext.getBean(Color.class);
        System.out.println(color);
        System.out.println(car);
    }
}
