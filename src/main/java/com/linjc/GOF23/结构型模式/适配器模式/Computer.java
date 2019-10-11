package com.linjc.GOF23.结构型模式.适配器模式;

/**
 * @Author Linjc
 * @Description 客户端类，
 * @date 2019/6/15
 */
public class Computer {

    public void request1(Target t) {
        t.handleReq();
    }

    public void request2(Target t) {
        t.handleReq();
    }

    public static void main(String[] args) {
        Computer computer1 = new Computer();
        Adapter1 adapter1 = new Adapter1();
        computer1.request1(adapter1);


        Computer computer2 = new Computer();
        Keyboard keyboard = new Keyboard();
        Adapter2 adapter2 = new Adapter2(keyboard);
        computer2.request2(adapter2);


    }
}
