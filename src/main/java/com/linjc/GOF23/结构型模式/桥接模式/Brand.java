package com.linjc.GOF23.结构型模式.桥接模式;

public interface Brand {
    void sayBrand();
}

class Lenovo implements Brand {
    @Override
    public void sayBrand() {
        System.out.print("联想");
    }
}


class Dell implements Brand {
    @Override
    public void sayBrand() {
        System.out.print("戴尔");
    }
}
