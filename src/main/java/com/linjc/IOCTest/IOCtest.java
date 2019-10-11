package com.linjc.IOCTest;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class IOCtest {
    public HashMap<String, Object> beans = new HashMap<String, Object>();

    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }

        Object bean = null;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (bean == null) {
            throw new RuntimeException("实例化不出来！！！！！！！！！！！！");
        }

        beans.put(beanId, bean);
    }

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }
}
