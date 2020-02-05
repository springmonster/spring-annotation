package com.kuang;

import com.kuang.aop.MyMath;
import com.kuang.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestOfAOP {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MyMath bean = annotationConfigApplicationContext.getBean(MyMath.class);
        bean.div(1, 1);
    }
}
