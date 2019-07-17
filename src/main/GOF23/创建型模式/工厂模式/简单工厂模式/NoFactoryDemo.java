package 创建型模式.工厂模式.简单工厂模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class NoFactoryDemo {
//    在没有工厂模式下，类NoFactoryDemo为调用者，
//    接口Car、类Audi、Byd等每一个实现类直接接触，严重耦合。


    public static void main(String[] args) {
        Car c1 = new Audi();
        Car c2 = new Byd();

        c1.run();
        c2.run();
    }
}
