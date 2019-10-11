package com.linjc.多线程.threadpool;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Author Linjc
 * @Description 定时线程池
 * @date 2019/9/1
 */
public class ThreadPoolExample4 {
    public static void main(String[] args) {
//        指定创建1个线程
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

//        schedule(scheduledExecutorService);
//        线程池记得关闭，不关闭的话jvm无法正常退出
//        scheduledExecutorService.shutdown();

//        这个方法因为需要循环执行，所以不要关闭线程池
//        scheduleAtFixedRate(scheduledExecutorService);

//        定时器
//        timer();

//        手动创建一个线程池
        createThreadPool();
    }

    /**
     * Description 手动创建一个线程池
     *
     * @param
     * @return void
     * @author Linjc
     * @date 2019/9/1
     */
    private static void createThreadPool() {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 12, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 100; i++) {
            int index = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "   " + index);
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    /**
     * Description 和ScheduledExecutorService作用类似
     *
     * @param
     * @return void
     * @author Linjc
     * @date 2019/9/1
     */
    private static void timer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "   " + "yytljc");
            }
        }, new Date(), 2 * 1000);
    }


    /**
     * Description 延时2秒钟执行下面的代码
     *
     * @param scheduledExecutorService
     * @return void
     * @author Linjc
     * @date 2019/9/1
     */
    private static void schedule(ScheduledExecutorService scheduledExecutorService) {
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                }
            }
        }, 2, TimeUnit.SECONDS);
    }

    /**
     * Description 延时一秒执行，然后每隔3秒重新执行一次，循环执行
     *
     * @param scheduledExecutorService
     * @return void
     * @author Linjc
     * @date 2019/9/1
     */
    private static void scheduleAtFixedRate(ScheduledExecutorService scheduledExecutorService) {
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                }
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
