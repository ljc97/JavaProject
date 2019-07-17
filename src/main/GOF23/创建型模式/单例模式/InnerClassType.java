package 创建型模式.单例模式;

/**
 * @Author Linjc
 * @Description 静态内部类创建单例模式
 * @date 2019/6/13
 */
public class InnerClassType {
//    1、私有化构造器
//    2、创建内部类，在内部类中创建当前类的实例对象
//    3、提供对外接口，访问内部类

    private InnerClassType(){
    }

//    该类被实例化后，并不会立即实例化静态内部类，
//    当对外接口被使用后，才会创建，所以该类属于延时加载
//    并且内部类加载时是天然线程安全的，保证了安全的同时提高了效率
    private static class InnerClass{
        private static final InnerClassType instance = new InnerClassType();
    }

    public static InnerClassType getInstance(){
        return InnerClass.instance;
    }
}
