package com.kuang;

import com.kuang.bean.MyDataSource;
import com.kuang.bean.Yellow;
import com.kuang.config.MainConfigOfProfile;
import com.kuang.config.MainConfigOfProfile1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestProfile {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(MyDataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Yellow bean = annotationConfigApplicationContext.getBean(Yellow.class);
        System.out.println(bean);
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev");
        annotationConfigApplicationContext.register(MainConfigOfProfile.class);
        annotationConfigApplicationContext.refresh();

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(MyDataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Yellow bean = annotationConfigApplicationContext.getBean(Yellow.class);
        System.out.println(bean);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("prod");
        annotationConfigApplicationContext.register(MainConfigOfProfile1.class);
        annotationConfigApplicationContext.refresh();

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(MyDataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Yellow bean = annotationConfigApplicationContext.getBean(Yellow.class);
        System.out.println(bean);
    }
}
