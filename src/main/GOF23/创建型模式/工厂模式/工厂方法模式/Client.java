package 创建型模式.工厂模式.工厂方法模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class Client {

    //    在工厂方法模式下，
//    创建一个接口的工厂，在创建具体实现类的工厂，
//    在调用者使用时，
//    只需要与具体实现类的工厂接触，而不需要与其他类接触，避免了耦合，
//    并且在扩展新类时，只需要添加新的实现类以及实现类的工厂即可，无需修改原来的代码
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BydFactory().createCar();

        c1.run();
        c2.run();

    }
}
