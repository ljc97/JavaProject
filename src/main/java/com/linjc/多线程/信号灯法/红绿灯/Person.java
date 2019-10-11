package com.linjc.多线程.信号灯法.红绿灯;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/16
 */
public class Person extends Thread {
    private Road road;

    public Person(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            road.walk();
//            road.walk()1;
        }
    }
}
