package 排序算法.交换排序;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 2, 3, 5, 9, 7, 4};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] a) {
        if (a == null || a.length == 0) {
            throw new RuntimeException("数组为空");
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] + a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] = a[j] - a[j + 1];
                }
            }
            System.out.println(Arrays.toString(a));
        }

    }
}
