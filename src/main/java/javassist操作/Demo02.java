package javassist操作;

import javassist.*;

import java.lang.reflect.Method;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/28
 */
public class Demo02 {
    private static void test1() throws Exception {
//        获取一个已经存在的对象
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("javassist操作.Emp");

//        创建新属性
        CtField f1 = new CtField(CtClass.intType, "salary", ctClass);
//        设置可见性
        f1.setModifiers(Modifier.PRIVATE);
        ctClass.addField(f1);

//        添加getter/setter方法
        ctClass.addMethod(CtNewMethod.getter("getSalary", f1));
        ctClass.addMethod(CtNewMethod.setter("setSalary", f1));


        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        Method m1 = clazz.getDeclaredMethod("setSalary", int.class);
        m1.invoke(obj, 233);

        Method m2 = clazz.getDeclaredMethod("getSalary", null);
        Object o = m2.invoke(obj, null);
        System.out.println(o);


    }

    public static void main(String[] args) throws Exception {
        test1();
    }
}
