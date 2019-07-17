package 信号灯法.红绿灯;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/16
 */
public class Car extends Thread {
    private Road road;

    public Car(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            road.drive();
//            road.drive1();
        }
    }
}
