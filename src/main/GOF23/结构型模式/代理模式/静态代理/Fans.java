package 结构型模式.代理模式.静态代理;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/15
 */
public class Fans {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        Star superStar = new ProxyStar(realStar);
        superStar.confer();
        superStar.signContract();
        superStar.bookTicket();
        superStar.sing();
        superStar.collectMoney();
    }
}
