package com.linjc.javassist操作;

import javassist.*;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/24
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
//        获得类池构造器
        ClassPool classPool = ClassPool.getDefault();
//        创建类名
        CtClass clazz = classPool.makeClass("Emp");

//        创建属性
        CtField f1 = CtField.make("private int id;", clazz);
        CtField f2 = CtField.make("private String age;", clazz);
//        将创建好的属性添加到类中
        clazz.addField(f1);
        clazz.addField(f2);

//        创建方法
        CtMethod m1 = CtMethod.make("public void setId(String id){this.id = id;}", clazz);
        CtMethod m2 = CtMethod.make("public int getId(){return id;}", clazz);
        clazz.addMethod(m1);
        clazz.addMethod(m2);

//        添加构造器
        CtConstructor c1 =
                new CtConstructor(new CtClass[]{}, clazz);
//        构造器内容
        c1.setBody("{}");

        CtConstructor c2 =
                new CtConstructor(new CtClass[]{CtClass.intType, classPool.get("java.lang.String")}, clazz);
        c2.setBody("{this.id=id;this.age=age;}");
        clazz.addConstructor(c1);
        clazz.addConstructor(c2);

//        将文件写入到指定位置
        clazz.writeFile("src\\main\\java\\javassist操作\\编译后的文件");

        System.out.println("输出成功");

    }
}
