package sort;

/**
 * ClassName:BubbleSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 21:53
 * @Version 1.0
 */
public class BubbleSort {
    static void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            //优化
            boolean flag=false;
            for (int j = nums.length-1; j>i ; j--) {
                if (nums[j]<nums[j-1]){
                    //交换位置
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                    flag=true;
                }
                if (flag==false){
                    //如果没有交换，说明已经有序
                    return;
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
