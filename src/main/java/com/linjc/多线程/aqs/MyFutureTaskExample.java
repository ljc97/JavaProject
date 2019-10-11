package com.linjc.多线程.aqs;

import java.util.concurrent.*;

/**
 * @Author Linjc
 * @Description /
 * @date 2019/9/1
 */
public class MyFutureTaskExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable do something");
                Thread.sleep(2000);
                System.out.println("something is done");
                return "success";
            }
        });

        new Thread(futureTask).start();
        System.out.println("main do another thing");
        Thread.sleep(1000);
//        在获取返回结果时，程序会一直阻塞在这里，直到获取的结果
        String result = futureTask.get();
        System.out.println("result:" + result);
    }
}