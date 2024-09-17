package sort;

/**
 * ClassName:QuickSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 16:53
 * @Version 1.0
 */
public class QuickSort {
    static void sort(int[] nums,int left,int right){
        //初始化
        //第一个元素作为枢纽
        if (left<right){
            int partition = partition(nums, left, right);
            sort(nums, left, partition-1);
            sort(nums, partition+1, right);
        }
    }
    static int partition(int[] nums,int left,int right){
        //初始化
        //第一个元素作为枢纽
        int pivot=nums[left];
        while (left<right){
            while (left<right&&nums[right]>=pivot){
                right--;
            }
            nums[left]=nums[right];
            while (left<right&&nums[left]<=pivot){
                left++;
            }
            nums[right]=nums[left];
        }
        //基准赋值
        nums[left]=pivot;
        //返回基准位置
        return left;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        sort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
