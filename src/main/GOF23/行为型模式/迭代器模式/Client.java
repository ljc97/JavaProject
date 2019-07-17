package 行为型模式.迭代器模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/20
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("000");
        cma.addObject("111");
        cma.addObject("222");
        cma.addObject("333");

        MyIterator interator = cma.createInterator();
        while (interator.hasNext()) {
            System.out.println(interator.getCurrentObj());
            interator.next();
        }


    }
}
