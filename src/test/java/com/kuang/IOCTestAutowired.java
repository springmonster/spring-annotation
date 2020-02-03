package com.kuang;

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
}
