package com.linjc.排序算法.归并排序;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 2, 3, 5, 9, 7, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int height) {
        int middle = (height + low) / 2;
        if (low >= height)
            return;

        System.out.println(Arrays.toString(arr));
//        处理左边
        mergeSort(arr, low, middle);
//        处理右边
        mergeSort(arr, middle + 1, height);
        merge(arr, low, middle, height);
    }

    private static void merge(int[] arr, int low, int middle, int height) {
//        用于存储归并后的临时数组
        int[] temp = new int[height - low + 1];
//        记录第一个数组中需要遍历的下标
        int i = low;
//        记录第二个数组中需要遍历的下标
        int j = middle + 1;
//        用于记录在临时数组中存放的下标
        int index = 0;
//        遍历两个数组,从中取出小的数字，放入临时数组中去
//        middle是分割数组的地方，拆成两块了
//        存在两块数组不一样大，可能出现一半已经遍历完，但是另一个还没有结束，
//        TODO 所以会存在多余的数据，下面要处理
        while (i <= middle && j <= height) {
//            数组被拆成两半，i是第一半的起始位置，j是第二半的起始位置
//            遍历两块数组，如果第一半的值小于等于第二半中的值
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
//                被遍历的数组值已经取完了，下标后移
                i++;
            } else {
//                否则就是第二半的元素更小
                temp[index] = arr[j];
                //                被遍历的数组值已经取完了，下标后移
                j++;
            }
//            记录下标也要移动
            index++;
        }
//        开始处理多余的数据
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= height) {
            temp[index] = arr[j];
            j++;
            index++;
        }
//        把临时数组放回原来的数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }
}
