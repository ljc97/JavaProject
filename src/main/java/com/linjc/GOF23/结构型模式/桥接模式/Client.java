package com.linjc.GOF23.结构型模式.桥接模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/16
 */
public class Client {

    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        DeskTop deskTop = new DeskTop(lenovo);
        deskTop.sale();
        LapTop lapTop = new LapTop(lenovo);
        lapTop.sale();

    }
}
