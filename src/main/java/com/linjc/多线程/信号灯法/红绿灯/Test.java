package com.linjc.多线程.信号灯法.红绿灯;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/16
 */
public class Test {
    public static void main(String[] args) {
//        创建被共同使用的资源
        Road road = new Road();
//        创建多线程
        Thread car = new Car(road);
        Thread person = new Person(road);

        car.start();
        person.start();
    }
}
