package com.linjc.错题记录;

/**
 * @Author Linjc
 * @Description /
 * @date 2019/8/16
 */
public class 静态块构造块 {
    {
        System.out.println("我是构造块1");
    }

    static {
        System.out.println("我是静态块1");
    }

    {
        System.out.println("我是构造块2");
    }

    static {
        System.out.println("我是静态块2");
    }

    public static void main(String[] args) {
        System.out.println("我是mian");
        静态块构造块 ss = new 静态块构造块();
    }
}
