package com.linjc.GOF23.创建型模式.工厂模式.工厂方法模式;

public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
