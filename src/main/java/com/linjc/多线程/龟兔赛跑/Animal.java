package com.linjc.多线程.龟兔赛跑;

public abstract class Animal {
    private String name;
}

class Rabbit extends Animal implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("兔子前进了" + i + "步");
//            当前线程放弃所有资源，让所有线程重新争夺执行的权利
            Thread.yield();
        }
    }
}

class Tortoise extends Animal implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("乌龟前进了" + i + "步");
//            当前线程放弃所有资源，让所有线程重新争夺执行的权利
            Thread.yield();
        }
    }
}


