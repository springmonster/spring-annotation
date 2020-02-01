package com.kuang.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorBeanFactory implements FactoryBean<Color> {

    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
