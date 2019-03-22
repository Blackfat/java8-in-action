package com.blackfat.algorithm;

import java.util.Arrays;

/**
 * @author wangfeiyang
 * @desc 归并排序
 * @create 2019/1/24-10:45
 */
public class MergeSort {


    public static void sort(int[] arr, int left, int right){
         if(arr == null || arr.length == 0){
             return ;
         }
        if(left >= right){
            return ;
        }

        int middle = (left + right)/2;

        sort(arr, left, middle);
        sort(arr, middle + 1, right);

        merge(arr, left , middle ,right);

    }


    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[arr.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex=left;
        // 逐个归并
        while(left <= mid && r1 <= right){
            if(arr[left] < arr[r1]){
                tmp[tIndex++] = arr[left++];
            }else{
                tmp[tIndex++] = arr[r1++];
            }
        }
        // 将左边剩余的归并
        while (left <=mid) {
            tmp[tIndex++] = arr[left++];
        }
        // 将右边剩余的归并
        while ( r1 <= right ) {
            tmp[tIndex++] = arr[r1++];
        }

        //从临时数组拷贝到原数组
        while(cIndex<=right){
            arr[cIndex]=tmp[cIndex];
            cIndex++;
        }



    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};

        sort(array,0, array.length -1);

        System.out.println(Arrays.toString(array));
    }


}
