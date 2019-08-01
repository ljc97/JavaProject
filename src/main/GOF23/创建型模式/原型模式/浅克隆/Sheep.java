package 创建型模式.原型模式.浅克隆;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author Linjc
 * @Description 被克隆模仿的原型，克隆羊多利
 * @date 2019/6/14
 */
@Setter
@Getter
public class Sheep implements Cloneable {
//    被模仿克隆的原型需要继承Cloneable接口，
//    但是这个接口没有需要重写的方法，属于一个标记接口

    private String name;

    private Date birthday;

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "DeepSheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
