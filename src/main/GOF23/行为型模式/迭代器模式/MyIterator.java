package 行为型模式.迭代器模式;

/**
 * Description 自定义迭代器接口
 *
 * @author Linjc
 * @date 2019/6/20
 * @return
 */
public interface MyIterator {
    //    将游标指向第一个
    void first();

    //    将游标指向下一个
    void next();

    //    判断是否有下一个
    boolean hasNext();

    //    是否为第一个故意最后一个
    boolean isFirst();

    boolean isLast();

    //    获取当前游标指向的对象
    Object getCurrentObj();

}
