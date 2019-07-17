package 行为型模式.中介者模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/20
 */
public class Client {

    public static void main(String[] args) {
        Meditor manager = new Manager();

        Department finacial = new Finacial(manager);
        Department development = new Development(manager);

        development.selfAction();
        System.out.println("--------");
        development.outAction();
    }
}
