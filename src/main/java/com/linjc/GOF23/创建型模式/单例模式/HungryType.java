package com.linjc.GOF23.创建型模式.单例模式;

/**
 * 饿汉式
 * 1）构造器私有化
 * 2）声明私有的静态属性，同时创建
 * 3）提供对外接口
 * 4）不能延时加载，如果没有使用，可能浪费创建资源
 */
public class HungryType {
    private static HungryType instance = new HungryType();

    private HungryType() {
    }

    public HungryType getInstance() {
        return instance;
    }
}
