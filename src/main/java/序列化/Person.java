package 序列化;

import java.io.Serializable;

/**
 * @version 1.0
 * @description: //TODO description
 * @author: 林经翀（jingchong.lin@ucarinc.com）
 * @date 2019/7/16 9:43
 */

public class Person implements Serializable {
    /**
     * static标识虽然这个字段无法参与序列化，
     * 但是也标识了这个字段属于类
     * 当类被创建了，自然就有了，和序列化结果无关
     */
    public static final String staticFinal = "staticFinalaaaa";

    private int id;
    private String name;
    private char sex;
    private transient String passWod;
    /**
     * 序列化发生在堆里，而静态字段在方法区，所以不参与序列化
     */
    public static String staticStr;

    /**
     * 反序列化时是使用无参的构造函数生成的对象，
     * 所以被final标注并且赋初值的属性属于初始化阶段完成，
     * 无法被transient影响
     */
    private transient final String finalStr;

    public Person(String s) {
        this.finalStr = s;
        System.out.println("wo shi gou zhao han shu");
    }

    public String getStaticFinal() {
        return staticFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPassWod() {
        return passWod;
    }

    public void setPassWod(String passWod) {
        this.passWod = passWod;
    }

    public static String getStaticStr() {
        return staticStr;
    }

    public static void setStaticStr(String staticStr) {
        Person.staticStr = staticStr;
    }

    public String getFinalStr() {
        return finalStr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", passWod='" + passWod + '\'' +
                ", staticStr='" + staticStr + '\'' +
                ", finalStr='" + finalStr + '\'' +
                ", staticFinal='" + staticFinal + '\'' +
                '}';
    }
}
