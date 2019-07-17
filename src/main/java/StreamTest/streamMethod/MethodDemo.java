package StreamTest.streamMethod;

import StreamTest.demo.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Linjc
 * @Description 几个基本的方法使用
 * @date 2019/5/22
 */
public class MethodDemo {

    public static void main(String[] args) {
//        filter();
//        limit();
//        skip();
//        map();
//        concat();
//        streamToList();
//        streamToSet();
        streamToMap();
    }

    private static void show(String s) {
        System.out.println(s);
    }


    private static void filter() {
        //        获取流
        Stream<String> one = Stream.of("宋江", "诸葛亮", "孔明", "及时雨");
//        完成一个操作，获取一个子集流
//        Stream<String> two = one.filter((e) -> {
//            return e.length() == 2;
//        });
        Stream<String> two = one.filter(e -> e.length() == 2);

//        two.forEach(e-> System.out.println(e));
//        two.forEach(System.out::println);
        two.forEach(MethodDemo::show);
    }

    private static void limit() {
        List<String> list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        Stream<String> one = list.stream();
        Stream<String> two = one.limit(6);

        two.forEach(System.out::println);

    }

    private static void skip() {
        List<String> list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        Stream<String> one = list.stream();
        Stream<String> two = one.skip(2);

        two.forEach(System.out::println);

    }

    /**
     * Description 把Stream<String>转化成Stream<Integer>就是map的功能
     *
     * @param
     * @return void
     * @author Linjc
     * @date 2019/5/22
     */
    private static void map() {
        List<String> list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        Stream<String> one = list.stream();
//        Stream<Integer> two = one.map(Integer::parseInt);
        Stream<Integer> two = one.map(e -> Integer.parseInt(e));

        two.forEach(System.out::println);
    }

    /**
     * Description 合并两个流，要求是类型一致
     *
     * @param
     * @return void
     * @author Linjc
     * @date 2019/5/22
     */
    private static void concat() {
        Stream<String> A = Stream.of("张三");
        Stream<String> B = Stream.of("李四");

        Stream<String> newOne = Stream.concat(A, B);

        newOne.forEach(System.out::println);
    }

    private static void streamToList() {
        Stream<String> stream = Stream.of("aaa", "bbb", "ccc", "ddd");
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(System.out::println);
//        System.out.println(list.toString());
    }

    private static void streamToSet() {
        Stream<String> stream = Stream.of("aaa", "bbb", "ccc", "ddd");
        Set<String> set = stream.collect(Collectors.toSet());
        for (String name : set) {
            System.out.println(name);
        }
    }

    private static void streamToMap() {
//        Stream<序列化.Person> personStream = Stream.of(new 序列化.Person("aa"), new 序列化.Person("ss"), new 序列化.Person("dd"));
//        Map<String, String> map = personStream.collect(Collectors.toMap(序列化.Person::getName, 序列化.Person::getName));
//        for (String key : map.keySet()) {
//            //map.keySet()返回的是所有key的值
//            String value = map.get(key);//得到每个key多对用value的值
//            System.out.println(key + "     " + value);
//        }
        Map<String, Person> map1 = new HashMap<>();
        map1.put("1", new Person("aaa"));
        map1.put("2", new Person("bbb"));
        map1.put("3", new Person("ccc"));
        map1.put("4", new Person("ddd"));

        Map<String, Person> map2 = new HashMap<>();
        map2.put("1", new Person("aa"));
        map2.put("2", new Person("bb"));
        map2.put("3", new Person("cc"));
        map2.put("4", new Person("dd"));

        List<Map<String, Person>> people = new LinkedList<>();
        people.add(map1);
        people.add(map2);

//        获取流
        Stream<Map<String, Person>> stream = people.stream();

//        删除key为2的数据
//        Stream<Map<String, 序列化.Person>> mapStream = stream.filter(e -> e.get("2").getName().startsWith("b"));

//        转化为map
        List<Map<String, Person>> collect = stream.collect(Collectors.toList());
//        打印显示
        for (Map<String, Person> map : collect) {
            for (String key : map.keySet()) {
                Person p = map.get(key);
                System.out.println(key + "     " + p.toString());
            }
        }
    }
}
