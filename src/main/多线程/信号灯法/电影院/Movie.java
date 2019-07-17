package 信号灯法.电影院;

/**
 * @Author Linjc
 * @Description 这就是一个场景，被多线程共同使用的资源
 * @date 2019/5/16
 */
public class Movie {
    private String msg;

    //    用于标识的信号灯
//    为T时，生产者生产，消费者等待
//    为F时，生产者等待，消费者消费
    private boolean flag = true;

    public synchronized void play(String msg) {
        if (!flag) {
            try {
//            为F时，生产者等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
//        生产耗时300
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        生产完毕
        this.msg = msg;

//        通知消费者开始消费
        this.notify();
        flag = false;
    }

    public synchronized void watch() {
        if (flag) {
            try {
//            为T时，消费者等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
//        消费耗时200
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        消费完毕
        System.out.println("正在播放" + msg);

//        通知生产
        this.notify();
        flag = true;
    }
}
