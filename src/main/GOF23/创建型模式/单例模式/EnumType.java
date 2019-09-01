package 创建型模式.单例模式;

/**
 * @Author Linjcyyt
 * @Description 枚举式创建单例
 * @date 2019/6/13
 */
public class EnumType {

//    优点：实现简单，由jvm从根本上提供了保证，不会被反射或者序列化造成漏洞

    private EnumType(){
    }

    public static EnumType getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    //    枚举也是一个普通的类，但是却是天然的单例
    private enum Singleton{
        INSTANCE;

        private EnumType singleton;

        Singleton(){
            singleton = new EnumType();
        }

        public EnumType getInstance(){
            return singleton;
        }

    }

    public static void main(String[] args) {
        System.out.println(EnumType.getInstance().hashCode());
        System.out.println(EnumType.getInstance().hashCode());
        System.out.println(EnumType.getInstance().hashCode());
        System.out.println(EnumType.getInstance().hashCode());
    }
}
