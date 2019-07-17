package 两军对抗.base;

//主舞台
public class Stage extends Thread {

    public void run() {
        System.out.println("------------ready---------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        创建两个军队
        ArmyRunnable r1 = new ArmyRunnable();
        ArmyRunnable r2 = new ArmyRunnable();

        Thread army1 = new Thread(r1, "隋军");
        Thread army2 = new Thread(r2, "反抗军");


        army1.start();
        army2.start();

//        舞台线程休眠
//        如果不休眠的话，main线程会立即执行下面的停战代码
//        可能导致直接停战
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //        两个军队停止作战
        r1.keepRunning = false;
        r2.keepRunning = false;

        Thread keyPerson = new KeyPersonThread();
        keyPerson.setName("我");


//        当前这个线程需要停一下，确保2个军队已经停止作战
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------注意------------");
        keyPerson.start();

//        其他线程等待keyPerson线程执行完成
        try {
            keyPerson.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------endding-----------");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
