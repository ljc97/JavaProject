package com.linjc.多线程.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Linjc
 * @Description /
 * @date 2019/9/1
 */
public class ThreadPoolExample1 {
    public static void main(String[] args) {
//        会自动创建线程，具体看构造函数
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + index);
                }
            });
        }
//        线程池记得关闭，不关闭的话jvm无法正常退出
        executorService.shutdown();
    }
}
