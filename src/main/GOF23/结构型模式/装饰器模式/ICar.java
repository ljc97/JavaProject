package 结构型模式.装饰器模式;

//抽象组件
public interface ICar {
    void move();
}


//具体构建角色（真是对象）
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("地上跑");
    }
}


class SuperCar implements ICar {
    protected ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

//ConcreTeDecorator具体装饰角色
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}


//ConcreTeDecorator具体装饰角色
class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("水上飞");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}


//ConcreTeDecorator具体装饰角色
class AutoCar extends SuperCar {

    public AutoCar(ICar car) {
        super(car);
    }

    public void autoMove() {
        System.out.println("自己动");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}
