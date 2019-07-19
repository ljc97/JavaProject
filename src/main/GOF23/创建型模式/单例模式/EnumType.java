package 创建型模式.单例模式;

/**
 * @Author Linjcyyt
 * @Description 枚举式创建单例
 * @date 2019/6/13
 */
public enum  EnumType {
//    优点：实现简单，由jvm从根本上提供了保证，不会被反射或者序列化造成漏洞
//    缺点：无法延时加载

//    定义一个枚举的元素，它就代表了一个实例
    INSTANCE;

//    单例可以有自己的操作
    public void singletonOperation(){
//        功能处理
    }

}
