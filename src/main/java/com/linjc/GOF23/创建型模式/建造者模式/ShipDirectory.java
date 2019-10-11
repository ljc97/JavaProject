package com.linjc.GOF23.创建型模式.建造者模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class ShipDirectory implements AirShipDirector {
    //    这里为具体的组装者
//    需要实现具体的创建
    private AirShipBuilder builder;

    public ShipDirectory(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directoryAirShip() {
//        获得创建者提供的具体零件
        Engine engine = builder.builderEngine();
        engine.setName("引擎666");
        EscapeTower escapeTower = builder.builderEscapeTower();
        escapeTower.setName("逃逸舱牛逼");
        OrbitalModule orbitalModule = builder.builderOrbitalModule();
        orbitalModule.setName("轨道舱233");


//        组装者得到零件后，开始组装目标
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalmodule(orbitalModule);

        return airShip;
    }
}
