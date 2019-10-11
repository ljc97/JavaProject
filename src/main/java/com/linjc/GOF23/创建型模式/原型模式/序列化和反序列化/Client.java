package com.linjc.GOF23.创建型模式.原型模式.序列化和反序列化;

import java.io.*;
import java.util.Date;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Date d = new Date();
        Sheep s1 = new Sheep("多利", d);
        System.out.println(s1.toString());


//        使用序列化和反序列化实现深复制，
//        原对象只需提供基本的clone() 方法
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s2 = (Sheep) ois.readObject();


        System.out.println("两者是否相等：" + (s1 == s2));
        d.setTime(1231231L);
        s1.setBirthday(d);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
