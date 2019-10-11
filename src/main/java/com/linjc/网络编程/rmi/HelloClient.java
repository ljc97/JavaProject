package com.linjc.网络编程.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端程序
 * 在客户端调用远程对象上的远程方法，并返回结果。
 *
 * @author linjc
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            //在RMI服务注册表中查找名称为RmiHello的对象，并调用其上的方法
            IHello localHello = (IHello) Naming.lookup("rmi://localhost:8888/RmiHello");
            System.out.println(localHello.sayHello());
            System.out.println(localHello.sayHelloTo("zzz"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}