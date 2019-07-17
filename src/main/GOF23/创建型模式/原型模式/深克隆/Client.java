package 创建型模式.原型模式.深克隆;

import java.util.Date;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/14
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date d = new Date();
        DeepSheep s1 = new DeepSheep("多利", d);
        System.out.println(s1.toString());

        DeepSheep s2 = (DeepSheep) s1.clone();
        s2.setName("少利");
        System.out.println(s2.toString());

        System.out.println("两者是否相等："+ (s1 == s2));

        d.setTime(1231231L);
        s1.setBirthday(d);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
