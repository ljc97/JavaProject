package 两军对抗.base;

public class KeyPersonThread extends Thread {
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "开始装逼了！");
        }
        System.out.println(Thread.currentThread().getName() + "装逼结束了！");
    }

}
