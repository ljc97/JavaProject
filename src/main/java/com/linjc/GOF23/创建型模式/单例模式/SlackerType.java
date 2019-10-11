package com.linjc.GOF23.创建型模式.单例模式;

public class SlackerType {

    /**
     * 懒汉式
     * 1）构造器私有化
     * 2）声明私有的静态属性
     * 3）提供对外接口
     * 4）可以延时加载，但是线程可能不安全，加上synchronized导致效率低
     */
    private static SlackerType slackerType;

    private SlackerType() {

    }

    /**
     * Description 这种写法在多线程效率更好一些
     * 双重检测锁实现
     *
     * @param
     * @return SlackerType
     * @author Linjc
     * @date 2019/6/13
     */
    private static SlackerType getInstance1() {
        if (slackerType == null) {
            synchronized (SlackerType.class) {
                if (SlackerType.class == null) {
                    slackerType = new SlackerType();
                }
            }
        }
        return slackerType;
    }

    private static synchronized SlackerType getInstance2() {
        if (slackerType == null) {
            slackerType = new SlackerType();
        }
        return slackerType;
    }

}
