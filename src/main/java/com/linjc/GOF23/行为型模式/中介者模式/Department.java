package com.linjc.GOF23.行为型模式.中介者模式;

//同事类的接口
public interface Department {
    //    做本部门的事情
    void selfAction();

    //    向总经理发出申请
    void outAction();
}


//具体的部门（研发部）
class Development implements Department {
    //    持有中介者的引用（总经理）
    private Meditor meditor;

    public Development(Meditor meditor) {
        this.meditor = meditor;
        meditor.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发部专心科研。。。");
    }

    @Override
    public void outAction() {
        System.out.println("研发部没钱了。。");
        meditor.command("finacial");
    }
}


//具体的部门（财务部）
class Finacial implements Department {
    //    持有中介者的引用（总经理）
    private Meditor meditor;

    public Finacial(Meditor meditor) {
        this.meditor = meditor;
        meditor.register("finacial", this);
    }

    @Override
    public void selfAction() {
        System.out.println("财务部大佬发钱了。。。");
    }

    @Override
    public void outAction() {
        System.out.println("财务部钱好多啊。。。");
    }
}


//具体的部门（市场部）
class Market implements Department {
    //    持有中介者的引用（总经理）
    private Meditor meditor;

    public Market(Meditor meditor) {
        this.meditor = meditor;
        meditor.register("market", this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场部需要资金支持。。。");
    }

    @Override
    public void outAction() {
        System.out.println("市场部在跑业务。。。");
    }
}