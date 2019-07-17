package 结构型模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/16
 */
public class StarHandler implements InvocationHandler {

    private RealStar realStar;

    public StarHandler(RealStar realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("sing")) {
            realStar.sing();
        } else {
            System.out.println("代理人正在处理！");
        }
        return null;
    }

}
