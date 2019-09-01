package example;

/**
 * @Author Linjc
 * @Description
 * @date 2019/7/31
 */
public class JoinThread implements Runnable {


    @Override

    public void run() {

        int i = 0;

        while (i < 300) {

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println(Thread.currentThread().getName() + " i:" + i);

            i++;

        }

    }

}

class Demo10 {

    public static void main(String[] args) throws InterruptedException {

        JoinThread jt = new JoinThread();

        Thread th = new Thread(jt, "one");

        th.start();

        int i = 0;

        while (i < 200) {

            if (i == 100) {

                th.join();

            }

            System.err.println(Thread.currentThread().getName() + " i:" + i);

            i++;


        }

    }

}