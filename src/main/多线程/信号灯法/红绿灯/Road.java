package 信号灯法.红绿灯;

/**
 * @Author Linjc
 * @Description 马路角色，是被多线程共同使用的资源
 * @date 2019/5/16
 */
public class Road {
    //    为T时，车可以走，人不行
    //    为F时，车不可以走，人行
    private boolean flag = true;

    public synchronized void walk() {
        if (flag) {
            try {
//                如果为真，车能走
//                但是进入这个方法的线程是人，所以让人等待通知 this.notify();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("人开始走路。。。");
            Thread.yield();
        }

//        车开始开，通知人停止走
        this.notify();
        flag = true;
    }

    public synchronized void drive() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
//            车开了400
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("车开始开了————");
            Thread.yield();
        }

//        车停止开，通知人开始走
        this.notify();
        flag = false;
    }


    public void walk1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("人开始走路。。。");
            Thread.yield();
        }
    }

    public void drive1() {
        for (int i = 0; i < 20; i++) {
            System.out.println("车开始开了————");
            Thread.yield();
        }
    }
}
