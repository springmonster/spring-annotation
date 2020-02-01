package com.kuang.selector;

import com.kuang.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.kuang.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.kuang.bean.Blue");
        if (red && blue) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainbow", rootBeanDefinition);
        }
    }
}
