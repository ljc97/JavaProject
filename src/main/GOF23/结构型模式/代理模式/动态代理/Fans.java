package 结构型模式.代理模式.动态代理;

import java.lang.reflect.Proxy;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/16
 */
public class Fans {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        StarHandler starHandler = new StarHandler(realStar);
        //通过JDK动态生成一个代理类
//        类代码     大致（可能有误）    如下面的类所示
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, starHandler);
        proxy.bookTicket();
        proxy.confer();
        proxy.sing();
        proxy.collectMoney();
    }
}


class ProxyStart implements Star {

//    Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
//            new Class[]{Star.class}, starHandler);
//    第二个参数为需要实现的接口有哪些，可以多个
//    第三个参数为将方法调用分派到的调用处理程序

    private StarHandler starHandler;

    public ProxyStart(StarHandler starHandler) {
        this.starHandler = starHandler;
    }

    @Override
    public void confer() {
//        starHandler.invoke(被反射的对象, "confer()", "反射时会调用的参数列表")
    }

    @Override
    public void signContract() {
//        starHandler.invoke(被反射的对象, "signContract()", "反射时会调用的参数列表")

    }

    @Override
    public void bookTicket() {
//        starHandler.invoke(被反射的对象, "bookTicket()", "反射时会调用的参数列表")

    }

    @Override
    public void sing() {
//        starHandler.invoke(被反射的对象, "sing()", "反射时会调用的参数列表")

    }

    @Override
    public void collectMoney() {
//        starHandler.invoke(被反射的对象, "collectMoney()", "反射时会调用的参数列表")

    }
}