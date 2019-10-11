package com.linjc.多线程.死锁;

import lombok.Data;

/**
 * 过多的同步方法在使用相同资源时，容易出现死锁
 */
public class SynDemo {
    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();

        Thread t1 = new Test1(g, m);
        Thread t2 = new Test2(g, m);
        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("估计是死锁了");
    }
}

@Data
class Test1 extends Thread {
    Object goods;
    Object money;

    public Test1(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        test();
    }

    private void test() {
        synchronized (goods) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (money) {

            }

            System.out.println("你先给货");
        }
    }

}


@Data
class Test2 extends Thread {
    Object goods;
    Object money;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        test();
    }

    private void test() {
        synchronized (money) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (goods) {

            }

            System.out.println("你先给钱");
        }
    }

}
