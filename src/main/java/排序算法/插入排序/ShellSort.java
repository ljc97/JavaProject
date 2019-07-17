package 排序算法.插入排序;

import java.util.Arrays;

//首先按照数组长度的一半拆分数组并且分组
//例如1和3一组，2和4一组
//然后插入排序组内的元素
//然后在按照步长的一半分组
//例如1,2,3,4,
//然后插入排序
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 2, 3, 5, 9, 7, 4};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
    }

    private static void shellSort(int[] arr) {
//        遍历所有步长，如果步长为0，则退出循环(步长初始是数组长度一半，下一次在一半，到0为止)
        int step = arr.length / 2;
        for (; step > 0; step /= 2) {
//            按步长分组完成后，遍历步长分组
            for (int i = step; i < arr.length; i++) {
//                遍历步长分组中的所有元素
                for (int j = i - step; j >= 0; j -= step) {
//                    如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + step]) {
                        int temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
