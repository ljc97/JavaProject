package com.linjc.排序算法.插入排序;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 2, 3, 5, 9, 7, 4};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
    }

    private static void insertSort(int[] a) {
        //遍历所有的数字
        for (int i = 1; i < a.length; i++) {
//            如果当前的数字小于前一个数字
            if (a[i] < a[i - 1]) {
//                把当前遍历的这个数字保存起来
                int temp = a[i];
//                遍历这个数字前面的所有数字
                int j;
                for (j = i - 1; j >= 0 && temp < a[j]; j--) {
//                    把前一个数字赋值给后一个数字
                    a[j + 1] = a[j];
                }
//                把temp(外层for循环中的当前元素)，赋值给不满足条件的后一个元素
                a[j + 1] = temp;
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
