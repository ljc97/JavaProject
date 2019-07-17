package InvokeTest.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

    //    是否打印信息
    private static final boolean isShow = true;

    /**
     * 打印类信息，包括类的成员变量和成员函数
     *
     * @param object
     */
    public static void printClassMessage(Object object) {
        //首先获取类的类类型
        Class c = object.getClass();
//        获取类的名称
        String className = c.getName();
        println(isShow, className);
//        获取类的方法
        Method[] methods = c.getMethods();
//        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
//            显示方法的名称
            String methodName = method.getName();
            println(false, method.getName());
//            得到方法的返回值类型的类类型
            Class returnType = method.getReturnType();
            String type = returnType.getName();
            println(false, returnType.getName());
            println(isShow, type, methodName);
        }
    }

    public static void getFields(Object object) {
        Class c = object.getClass();
        println(isShow, c.getSimpleName());
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String typeName = field.getType().getName();
            String fieldName = field.getName();
            println(isShow, typeName, fieldName);
        }
    }

    static void getContructor(Object object) {
        Class c = object.getClass();
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getSimpleName() + ",");
            }
            System.out.println(")");
        }
        System.out.println();
    }

    private static void println(boolean tag, String... msg) {
        if (tag) {
            for (int i = 0; i < msg.length; i++) {
                System.out.print(msg[i] + "  ");
            }
            System.out.println();
        }
    }
}
