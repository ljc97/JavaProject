package com.linjc.StreamTest.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/23
 */
public class ListTest {

    private static LinkedList<String> list1 = new LinkedList<>();
    private static LinkedList<String> list2 = new LinkedList<>();
    private static ListIterator<String> iterator = null;

    public static void main(String[] args) {
//        初始化两个队伍
        init();
//        1、第一个队伍只要名字为3个字的
        iterator = list1.listIterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.length() != 3) {
                iterator.remove();
            }
        }
//        2、第一个队伍筛选之后只要前3个人
        for (int i = 0; i < list1.size(); i++) {
            if (i >= 3) {
                list1.remove(i);
                --i;
            }
        }
//        3、第二个队伍只要姓‘张’的人
        iterator = list2.listIterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (!name.startsWith("张")) {
                iterator.remove();
            }
        }
//        4、第二个队伍筛选之后不要前2个人
        iterator = list2.listIterator();
        int i = 1;
        while (iterator.hasNext()) {
            String name = iterator.next();
            iterator.remove();
            i++;
            if (i == 2) {
                break;
            }
        }
//        5、将两个队伍合并成一个
        LinkedList<String> newList = list1;
        newList.addAll(list2);
//        6、根据姓名创建person对象
        List<Person> persons = new LinkedList<>();
        for (String name : newList) {
            persons.add(new Person(name));
        }
//        7、打印整个队伍的person信息
        for (Person person : persons) {
            System.out.println(person.toString());
        }
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
