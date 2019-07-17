package InvokeTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static final boolean isShow = false;//是否显示输出信息

    public static void println(String str) {
        if (isShow) {
            System.out.println("--------------this is begin-------------");
            System.out.println(str);
            System.out.println("--------------this is end-------------");
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        showWant(Person.class);
    }

    public static void showWant(Class<?> clazz) throws IllegalAccessException {
        println("Class name is:" + clazz.getSimpleName());

        Method[] methods = clazz.getDeclaredMethods();//所有申明的方法
        Field[] fields1 = clazz.getDeclaredFields();//所有申明的属性
        Field[] fields2 = clazz.getFields();//公开的属性

        showMethids(methods);
//        showFields(fields2);
        showFields(fields1);

        Person p = new Person();
        tryInvoke(fields1, p);
        System.out.println(p.toString());

    }

    public static void showMethids(Method[] methods) {
        if (methods != null && methods.length > 0) {
            for (Method method : methods) {
                println(method.getName());
            }
        }
    }

    public static void showFields(Field[] fields) {
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                println(field.getName());
            }
        }
    }

    public static void tryInvoke(Field[] fields, Object object) throws IllegalAccessException {
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals("age")) {
                    field.set(object, 1);
                }
            }
        }
    }
}
