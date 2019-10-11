package com.linjc.多线程.example;

public class Actor extends Thread {
    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Lin");

        Thread actress = new Thread(new Actress());
        actress.setName("Miss.Yu");

        actor.start();
        actress.start();
    }


    @Override
    public void run() {
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
//            继承Thread的类可以通过getName()获取当前线程的名称，
//            重写Runnable的不能使用此方法
            System.out.println(getName() + "正在演出：" + count + "次");

            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count == 100) {
                return;
            }
            count++;
        }
    }
}

class Actress implements Runnable {
    @Override
    public void run() {
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
//            继承Thread的类可以通过getName()获取当前线程的名称，
//            重写Runnable的不能使用此方法
//            System.out.println(getName()+"正在演出："+count+"次");
            System.out.println(Thread.currentThread().getName() + "正在演出：" + count + "次");
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count == 100)
                return;
            count++;
        }
    }
}
