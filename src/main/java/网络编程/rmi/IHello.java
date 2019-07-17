package 网络编程.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义一个远程接口，必须继承Remote接口，其中需要远程调用的方法必须抛出RemoteException异常
 */
public interface IHello extends Remote{

    //远程调用的方法必须有返回值，不能为void
    //必须抛出RemoteException异常,否认则Client运行时会抛出RemoteException异常
    String sayHello() throws RemoteException;
    String sayHelloTo(String somebody) throws RemoteException;
}