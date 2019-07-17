package 递归;

public class Hanoi {

    public static void main(String[] args) {
        moveHanoi(3, "A", "B", "C");
    }

    /**
     * @param n      共有几个盘子
     * @param start  起始柱子
     * @param help   中间柱子
     * @param target 目标柱子
     */
    public static void moveHanoi(int n, String start, String help, String target) {
//        只有一个盘子的时候
        if (n == 1) {
            System.out.println("第" + n + "个盘子从" + start + "移动到" + target);
        } else {
//            把  除了最下面的盘子以外的其他盘子看做一个整体
//            首先就是把上面那个部分移动到中间柱子
//            所以开始从start，借助target，移动到目标help上
            moveHanoi(n - 1, start, target, help);
//            移动最下面的盘子
            System.out.println("第" + n + "个盘子从" + start + "移动到" + target);
//            把除了之前最后一个的所有盘子，从中间的柱子（help）借助第一个柱子（start）移动到最后一个柱子上（target）
            moveHanoi(n - 1, help, start, target);
        }
    }
}
