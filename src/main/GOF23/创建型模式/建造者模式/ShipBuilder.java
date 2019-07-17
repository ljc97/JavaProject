package 创建型模式.建造者模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class ShipBuilder implements AirShipBuilder{

//    这里为具体的创建者，
//    需要继承创建接口，并且实现具体的创建方法

    @Override
    public OrbitalModule builderOrbitalModule() {
        return new OrbitalModule();
    }

    @Override
    public Engine builderEngine() {
        return new Engine();
    }

    @Override
    public EscapeTower builderEscapeTower() {
        return new EscapeTower();
    }
}
