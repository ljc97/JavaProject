package com.linjc.多线程.example;

public class Web12306 implements Runnable {
    int num = 50;

    @Override
    public void run() {
        test3();
    }


    public void test1() {
        while (true) {
            if (num <= 0)
                break;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");

        }
    }

    public synchronized void test2() {
        while (true) {
            if (num <= 0)
                break;

            System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");
        }
    }

    public void test3() {
        synchronized (this) {
            while (true) {
                if (num <= 0)
                    break;

                System.out.println(Thread.currentThread().getName() + "抢到了第" + num-- + "张票");
            }
        }
    }
}

class DemoMain {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread zhangsan = new Thread(web12306);
        zhangsan.setName("张三");
        Thread hn1 = new Thread(web12306);
        hn1.setName("黄牛1");
        Thread hn2 = new Thread(web12306);
        hn2.setName("黄牛2");

        zhangsan.start();
        hn1.start();
        hn2.start();
    }
}
