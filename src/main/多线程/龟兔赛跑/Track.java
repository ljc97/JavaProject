package 龟兔赛跑;

public class Track {
    public static void main(String[] args) {
        Thread rabbit = new Thread(new Rabbit());
        Thread tortise = new Thread(new Tortoise());

//        设置优先级
        rabbit.setPriority(5);
        tortise.setPriority(5);

        rabbit.start();
        tortise.start();

    }
}
