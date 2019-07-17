package 递归;

public class Febonacci {
    // 1 1 2 3 5 8 13 21
    public static void main(String[] args) {
        System.out.println(febonacci(8));
//        show(10);
    }

    //显示第n个斐波那契数
    private static int febonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return febonacci(n - 1) + febonacci(n - 2);
        }
    }


    //    显示n个斐波那契数列
    private static void show(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 6 == 0) {
                System.out.println();
            }
            System.out.print(febonacci(i) + "  ");
        }
    }
}
