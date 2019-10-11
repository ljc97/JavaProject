package com.linjc.GOF23.创建型模式.建造者模式;

public interface AirShipBuilder {
    //飞船创建的工厂
    //用户生产各个零件

    OrbitalModule builderOrbitalModule();

    Engine builderEngine();

    EscapeTower builderEscapeTower();
}
