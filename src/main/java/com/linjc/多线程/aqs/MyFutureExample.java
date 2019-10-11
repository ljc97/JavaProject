package com.linjc.多线程.aqs;

import java.util.concurrent.*;

/**
 * @Author Linjc
 * @Description /
 * @date 2019/9/1
 */
public class MyFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyTask());
        System.out.println("main do another thing");
        Thread.sleep(1000);
//        在获取返回结果时，程序会一直阻塞在这里，直到获取的结果
        String result = future.get();
        System.out.println("result:" + result);
        executorService.shutdown();
    }
}

class MyTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable do something");
        Thread.sleep(2000);
        System.out.println("something is done");
        return "success";
    }
}