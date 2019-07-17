package 排序算法;

import java.util.LinkedList;
import java.util.List;

public class ThreadSort implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(Long.parseLong(Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        String[] arr = {"200", "500", "120", "600", "599"};
        threadSort(arr);
    }

    private static void threadSort(String[] arr) {
        List list = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
//            创建线程时传入一个runnable对象，以及需要排序的数组中的值作为该线程的线程名
            Thread thread = new Thread(new ThreadSort(), arr[i]);
            list.add(thread);
        }
        for (Object thread : list) {
            Thread t = (Thread) thread;
            t.start();
        }
    }
}
