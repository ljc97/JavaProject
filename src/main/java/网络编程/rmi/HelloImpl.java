package 网络编程.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 定义远程接口的实现类
 * 继承UnicastRemoteObject 父类并实现自定义的远程接口
 * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，必须声明抛出RemoteException异常
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

    public HelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        //System.out.println("hello!");
        return "hello";
    }

    @Override
    public String sayHelloTo(String somebody) throws RemoteException {
        //System.out.println("hello" + somebody);
        return "hello" + somebody;
    }
}
