package 排序算法.选择排序;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 2, 3, 5, 9, 7, 4};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
    }

    private static void selectSort(int[] arr) {
//        遍历所有的数
        for (int i = 0; i < arr.length; i++) {
//            默认最小的元素的下标为当前这个元素
            int minIndex = i;
//            把当前遍历的数和后面所有的数，依次遍历，取出最小的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
//            如果最小的元素的下标和当前遍历的下标不一致（发现了更小的元素）
//            否则就是没有发现更小的，说明当前元素是最小的，则不做任何操作
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
