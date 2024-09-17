package sort;

/**
 * ClassName:ShellSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 22:11
 * @Version 1.0
 */
public class ShellSort {
    static void sort(int[] nums){
        //第一个循环是步长，步长最小为1
        for (int dk = nums.length/2; dk >=1; dk/=2) {
            for (int i = dk; i < nums.length; i++) {
                if (nums[i]<nums[i-dk]){
                    //往左边每次移动步长，走到边界或者遇到比他它更小的就停止
                    int temp=nums[i];
                    int l=i-dk;
                    for (;l>=0&&nums[l]>temp;l-=dk){
                        //记录后移
                        nums[l+dk]=nums[l];
                    }
                    nums[l+dk]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
