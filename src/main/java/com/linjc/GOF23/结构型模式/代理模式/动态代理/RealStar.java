package com.linjc.GOF23.结构型模式.代理模式.动态代理;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/15
 */
public class RealStar implements Star {

    @Override
    public void sing(String startName) {
        System.out.println(startName + "正在唱歌");
    }

    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void collectMoney() {

    }
}
