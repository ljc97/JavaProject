package com.linjc.GOF23.结构型模式.桥接模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/16
 */
public class ComputerType {
    protected Brand brand;

    public ComputerType(Brand brand) {
        this.brand = brand;
    }

    public void sayBrand() {
        brand.sayBrand();
    }
}

class DeskTop extends ComputerType {

    public DeskTop(Brand brand) {
        super(brand);

    }

    public void sale() {
        super.sayBrand();
        System.out.println("台式销售一台");
    }
}


class LapTop extends ComputerType {

    public LapTop(Brand brand) {
        super(brand);
    }

    public void sale() {
        super.sayBrand();
        System.out.println("笔记本销售一台");
    }
}
