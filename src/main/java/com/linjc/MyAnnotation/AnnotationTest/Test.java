package com.linjc.MyAnnotation.AnnotationTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    @Annotation1(name = "zzzzzz")
    public void test1() {
        System.out.println("test1()");
    }

    @Annotation1("test2")
    public void test2() {
        System.out.println("test2()");
    }

    public static void main(String[] args) {
        Class clazz = Test.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            boolean tag = method.isAnnotationPresent(Annotation1.class);
            if (tag) {
                Annotation1 annotation1 = method.getAnnotation(Annotation1.class);
                System.out.println(annotation1.value());
                System.out.println(annotation1.name());
                try {
                    method.invoke(clazz.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                } catch (InstantiationException e) {
                }
            }
        }
    }
}
