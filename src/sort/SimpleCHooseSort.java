package sort;

/**
 * ClassName:SimpleCHooseSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 22:01
 * @Version 1.0
 */
public class SimpleCHooseSort {
    static void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min=i;
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[j]<nums[min]){
                    min=j;
                }
            }
            //交换
            int temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
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
