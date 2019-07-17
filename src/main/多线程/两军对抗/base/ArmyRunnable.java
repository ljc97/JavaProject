package 两军对抗.base;

//军队线程
//模拟双方作战的行为
public class ArmyRunnable implements Runnable {
    //    volatile关键字保证了线程可以正确的读取其他线程写入的值
//    可见性
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
//            军队发动五次攻击
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "正在进攻第：" + i + " 次");

//                让出CPU资源，下次进程需要重新进行争夺资源。
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName() + "结束了战斗！");
    }
}
