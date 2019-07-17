package 结构型模式.装饰器模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/18
 */
public class Client {

    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        System.out.println("增加飞行功能。。。");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("在增加水上飞功能。。。");
        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();

    }
}
