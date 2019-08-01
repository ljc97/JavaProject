package 结构型模式.组合模式.模拟杀毒软件;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/17
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f1, f2, f3, f4, f5;
        f1 = new Floder();
        f2 = new ImgFile();
        f3 = new textFile();
        f4 = new Floder();
        f5 = new videoFile();
        ((Floder) f1).add(f2);
        ((Floder) f1).add(f3);


        ((Floder) f4).add(f5);
        ((Floder) f1).add(f4);

        f4.killVirus();
    }
}
