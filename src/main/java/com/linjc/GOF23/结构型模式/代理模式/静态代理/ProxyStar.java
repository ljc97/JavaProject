package com.linjc.GOF23.结构型模式.代理模式.静态代理;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/15
 */
public class ProxyStar implements Star {
    private RealStar realStar;

    public ProxyStar(RealStar realStar) {
        this.realStar = realStar;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar正在面谈");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar正在签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar正在订票");
    }

    /**
     * Description 真实需要的对象才能做的方法
     *
     * @param
     * @return void
     * @author Linjc
     * @date 2019/6/15
     */
    @Override
    public void sing() {
        realStar.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar正在收钱");
    }
}
