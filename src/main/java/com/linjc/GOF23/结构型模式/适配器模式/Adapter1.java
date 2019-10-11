package com.linjc.GOF23.结构型模式.适配器模式;

/**
 * @Author Linjc
 * @Description 实现适配器有两种方式
 * 1、适配器类继承需要适配的目标（类适配方式）
 * 2、
 * @date 2019/6/15
 */
public class Adapter1 extends Keyboard implements Target {
    @Override
    public void handleReq() {
        super.request();
    }
}
