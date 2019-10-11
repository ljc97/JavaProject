package com.linjc.GOF23.创建型模式.工厂模式.简单工厂模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class CarFactoryDemo {

    public static void main(String[] args) {
//       在简单工厂模式下，
//       客户端只需与接口Car和所需要的实现类标志接触
//        并没有和具体实现类接触

        Car c1 = createCar("奥迪");
        Car c2 = createCar("比亚迪");

        c1.run();
        c2.run();
    }


    public static Car createCar(String carName) {
        if (carName.equals("奥迪")) {
            return new Audi();
        }
        if (carName.equals("比亚迪")) {
            return new Byd();
        }
        return null;
    }
}
