package com.linjc.MyAnnotation.MyORM;

import java.lang.reflect.Field;

/**
 * @Author Linjc
 * @Description 处理注解信息
 * @date 2019/5/22
 */
public class Demo {
    /**
     * Description 获取类的所有注解
     *
     * @param clazz
     * @return void
     * @author Linjc
     * @date 2019/5/22
     */
    public static void dealClass(Class clazz, StringBuffer sb) {
//        Annotation[] annotations = clazz.getAnnotations();
//        for (Annotation annotation : annotations) {
//            if(annotation instanceof MyTable){
//                MyTable myTable = (MyTable) annotation;
//                System.out.println(myTable.value());
//            }
//        }


//        获取指定的某一个注解
        MyTable myTable = (MyTable) clazz.getAnnotation(MyTable.class);
        if (myTable != null) {
            sb.append("Create table if not exit");
            sb.append("'" + myTable.value() + "' (\n");
        }
    }

    /**
     * Description 获取类中所有属性的注解
     *
     * @param clazz
     * @return void
     * @author Linjc
     * @date 2019/5/22
     */
    public static void dealFields(Class clazz, StringBuffer sb) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            MyField myField = field.getAnnotation(MyField.class);
            if (myField != null) {
                String columnName = myField.columnName();
                int length = myField.length();
                String type = myField.type();

                sb.append("'" + columnName + "' " + type + "(" + length + "),\n");
            }
        }
        sb.append(")");
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        dealClass(StudentTest.class, sb);
        dealFields(StudentTest.class, sb);

        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb.toString());
    }
}
