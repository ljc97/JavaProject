package 排序算法.交换排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 2, 3, 5, 9, 7, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //        数组中的起始位置作为标准
            int stander = arr[start];
//        需要排序的下标
            int low = start;
            int height = end;
//        循环找出比标准数大的和小的数字
            while (low < height) {
//            高位那边的数字比标准数大，则标志位height后移一位
                while (low < height && stander <= arr[height]) {
                    height--;
                }
//            使用基准线右边的数字替换左边的数字
                arr[low] = arr[height];
//            如果左边的数字比标准数小
                while (low < height && arr[low] < stander) {
                    low++;
                }
                arr[height] = arr[low];
            }
//        把标准数赋给低位数（高位数和低位数重合了）
            arr[low] = stander;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }
}
