package com.linjc.类加载过程;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/31
 */
public class Demo1 {
    static {
        System.out.println("初始化Demo1");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Demo1的main方法");
//        主动引用（一定会发生类的初始化）
//        A a = new A();
//        System.out.println(A.width);
//        A.sayHello();
//        Class.forName("A");


//        被动引用（不会发生类的初始化）
//        System.out.println(A_Children.width);
//        A[] as = new A[10];
//        System.out.println(A.max);
    }

}

class A extends A_Father {
    public static int width = 100;
    public static final int max = 100;

    static {
        width = 300;
        System.out.println("A的静态初始化块");
    }

    public A() {
        System.out.println("A的构造器");
    }

    public static void sayHello() {
        System.out.println("A的sayHello方法");
    }
}

class A_Father {
    static {
        System.out.println("A_Father的静态初始化块");
    }

    public A_Father() {
        System.out.println("A_Father的构造器");
    }
}

class A_Children extends A {
    static {
        System.out.println("A_Children的静态初始化块");
    }

    public A_Children() {
        System.out.println("A_Father的构造器");
    }
}
