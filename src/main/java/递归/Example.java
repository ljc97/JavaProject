package 递归;

public class Example {
    public static void main(String[] args) {
        print(10);
    }

    private static void print(int n) {
        if (n >= 0) {
            System.out.println(n);
            print(n--);
        }
    }
}
