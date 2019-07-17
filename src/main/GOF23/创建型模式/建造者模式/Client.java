package 创建型模式.建造者模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class Client {

    public static void main(String[] args) {
        AirShipBuilder builder = new ShipBuilder();
        AirShipDirector director = new ShipDirectory(builder);

        AirShip airShip = director.directoryAirShip();

        System.out.println(airShip.getEngine().getName());
    }
}
