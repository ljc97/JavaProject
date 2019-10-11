package com.linjc.错题记录;

/**
 * @Description: //TODO
 * @Author: 林经翀（jingchong.lin@ucarinc.com）
 * @Date 2019/8/20 16:51
 * @Version 1.0
 */
public class B
{

    public static B t1 = new B();
    public static B t2 = new B();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块2");
    }

    public static void main(String[] args) {
        B t = new B();
    }
}
