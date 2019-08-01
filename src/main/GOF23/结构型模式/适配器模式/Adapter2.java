package 结构型模式.适配器模式;

/**
 * @Author Linjc
 * @Description 实现适配器有两种方式
 * 1、
 * 2、在适配器中引入被适配的对象（对象适配器方式，使用了组合的方式跟被适配对象整合）
 * @date 2019/6/15
 */
public class Adapter2 implements Target {

    private Keyboard keyboard;

    public Adapter2(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public void handleReq() {
        keyboard.request();
    }
}
