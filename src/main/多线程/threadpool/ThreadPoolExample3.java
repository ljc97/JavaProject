package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Linjc
 * @Description /
 * @date 2019/9/1
 */
public class ThreadPoolExample3 {
    public static void main(String[] args) {
//        指定创建1个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
