package sort;

import dynamic.NumSquares;

import java.util.concurrent.ForkJoinPool;

/**
 * ClassName:MergeSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 20:53
 * @Version 1.0
 */
public class MergeSort {
    static void sort(int[] nums,int left,int right){
        if (left<right){
            int mid=left+((right-left)>>1);
            sort(nums, left, mid);
            sort(nums, mid+1,  right);
            merge(nums, left, mid, right);
        }
    }
    static void GuiSort(int[] nums){
        if (nums == null || nums.length < 2) {
            return; // 处理特殊情况
        }
        sort(nums,0,nums.length-1);
    }
    static void merge(int[] nums,int left,int mid,int right){
        int[] help=new int[right-left+1];
        int k=0;
        int i = left,j=mid+1;
        for (; i <=mid&&j<=right ; ) {
            if (nums[i]<nums[j]){
                help[k++]=nums[i++];
            }
            else {
                help[k++]=nums[j++];
            }
        }
        //两个while只能执行一个
        while (i<=mid){
            //右边遍历完了，左边有剩余
            help[k++]=nums[i++];
        }
        while (j<=right){
            //有边有剩余
            help[k++]=nums[j++];
        }
        //把辅助数组的值都给他
        for (int l = 0; l < help.length; l++) {
            nums[left+l]=help[l];
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        GuiSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
