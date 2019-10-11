package com.linjc.多线程.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author Linjc
 * @Description 多线程环境下测试容器
 * @date 2019/9/1
 */
public class 多线程测试器 {
    //    总共有5000个请求
    private static int clientCount = 5000;

    //    同时可以并发执行的最大数量
    private static int threadTotal = 200;

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        信号量，每次允许执行的最大数量
        final Semaphore semaphore = new Semaphore(threadTotal);
//        线程计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        for (int i = 0; i < clientCount; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    计数器 - 1
//                    如果不使用计数器减1，则会导致await方法死等待
                    countDownLatch.countDown();
                }
            });
        }
//        计数器的值要减为0才允许继续向下执行
        countDownLatch.await();
//        下面这个方法是指：线程等待100毫秒，如果全部任务还有没执行完的，就忽略等待，向下执行
//        countDownLatch.await(100,TimeUnit.MILLISECONDS);
//        关闭线程池（如果有已经创建，但是没有执行完的线程，会继续执行，没有创建的线程就不创建了）
        executorService.shutdown();
        System.out.println(list.size());
    }

    private static void update(int count) throws InterruptedException {
        list.add(count);
    }

}
