package 结构型模式.享元模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/19
 */
public class Client {

    public static void main(String[] args) {
        ChessFlyWeight white = ChessFlyWeightFactory.getChess("white");

        ChessFlyWeight black = ChessFlyWeightFactory.getChess("black");

        System.out.println("增加外部状态。。。。。");
        black.display(new Coordinate(10, 10));
        black.display(new Coordinate(20, 20));


    }
}
