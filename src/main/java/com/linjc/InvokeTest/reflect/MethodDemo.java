package com.linjc.InvokeTest.reflect;

import java.lang.reflect.Method;

public class MethodDemo {

    public static void main(String[] args) {
        A a = new A();
        Class c = a.getClass();
        try {
            Method method1 = c.getDeclaredMethod("print", int.class, int.class);
            method1.invoke(a, 1, 1);

            Method method2 = c.getDeclaredMethod("print", String.class, String.class);
            method2.invoke(a, "hello", "WORD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}