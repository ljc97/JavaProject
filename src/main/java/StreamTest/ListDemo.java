package StreamTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/22
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("000");
        list.add("101");
        list.add("102");
        list.add("103");
        list.add("1044");
//        list.stream().filter(s -> s.contains("1")).filter(s -> s.length() == 3).forEach(e -> System.out.println(e));
//        list.stream().filter(s -> s.contains("1")).filter(s -> s.length() == 3).forEach(System.out::println);

        System.out.println(list.stream().count());

    }
}
