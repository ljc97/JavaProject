package com.linjc.InvokeTest.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Class c = arrayList.getClass();
        try {
            Method method = c.getDeclaredMethod("add", Object.class);
            method.invoke(arrayList, 1);
            System.out.println(arrayList.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
