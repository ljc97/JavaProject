package com.linjc.多线程.example;

/**
 * @Author Linjc
 * @Description
 * @date 2019/7/31
 */
public class SetDaemon implements Runnable {

    int i = 0;


    @Override
    public void run() {

        while (true) {
            System.out.println(Thread.currentThread().getName() + " 检测是否有可用更新");
            i++;
            try {

                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 100) {
                System.out.println("有可用更新，是否升级？");
                break;
            }
        }
    }
}

class Demo9 {
    public static void main(String[] args) {
        SetDaemon qq = new SetDaemon();
        Thread th = new Thread(qq, "qqupdate");
        th.setDaemon(true);
        th.start();
        try {
            Thread.sleep(81);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(th.isDaemon());
        System.out.println("hello world");
    }
}