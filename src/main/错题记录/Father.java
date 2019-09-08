import java.util.LinkedList;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: 林经翀（jingchong.lin@ucarinc.com）
 * @Date 2019/8/20 10:56
 * @Version 1.0
 */
public class Father {
    String baseName = "father";

    public Father() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }
}

class son extends Father {
    String baseName = "son";

    @Override
    public void callName() {
        System.out.println(baseName);
    }
}

class Client{
    public static void main(String[] args) {
        Father f = new son();
        String str="0,1,2";
        String[] split = str.split(",");
        System.out.println(split.length);
        System.out.println(str.length());
        List list = new LinkedList();
        System.out.println(list.size());
    }
}