package StreamTest.demo;

import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/23
 */
public class StreamTest {
    private static LinkedList<String> list1 = new LinkedList<>();
    private static LinkedList<String> list2 = new LinkedList<>();

    public static void main(String[] args) {
        init();
//        1、第一个队伍只要名字为3个字的,并且只要前三个
        Stream<String> step1 = list1.stream();
        Stream<String> step2 = step1.filter(e -> e.length() == 3).limit(3);
//        3、第二个队伍只要姓‘张’的人,并且不要前两个
        Stream<String> step3 = list2.stream();
        Stream<String> step4 = step3.filter(e -> e.startsWith("张")).skip(2);
//        5、将两个队伍合并成一个
        Stream<String> newStream = Stream.concat(step2, step4);
//        6、根据姓名创建person对象,并且打印整个队伍信息
        Stream<Person> personStream = newStream.map(Person::new);
//        Stream<序列化.Person> personStream = newStream.map(e -> new 序列化.Person(e));
        personStream.forEach(System.out::println);
    }

    private static void init() {
//        1、第一个队伍只要名字为3个字的
//        2、第一个队伍筛选之后只要前3个人
//        3、第二个队伍只要姓‘张’的人
//        4、第二个队伍筛选之后不要前2个人
//        5、将两个队伍合并成一个
//        6、根据姓名创建person对象
//        7、打印整个队伍的person信息
        list1.add("迪丽热巴");
        list1.add("宋远桥");   //ok
        list1.add("苏新河");   //ok
        list1.add("石破天");   //ok
        list1.add("石中剑");
        list1.add("老子");
        list1.add("庄子");
        list1.add("洪七公");

        list2.add("张三");
        list2.add("李小四");
        list2.add("张大锤");
        list2.add("张白");    //ok
        list2.add("张黑");    //ok
        list2.add("superMan");
        list2.add("batMan");
        list2.add("啦啦啦");
    }
}
