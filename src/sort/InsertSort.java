package sort;

/**
 * ClassName:InsertSort
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/15 15:01
 * @Version 1.0
 */
public class InsertSort {
    static int[]  sort(int[] nums){
        //先让局部有序
        int j;
        //0用来当哨兵
        for (int i = 1; i < nums.length; i++) {
            //todo 后一个比前一个小
            if (nums[i]<nums[i-1]){
               int temp=nums[i];//复制为哨兵
                //j>=0必须放在前面，负责nums[j]的j会取到-1
                for (j = i-1; j>=0 &&temp<nums[j]; j--) {
                    nums[j+1]=nums[j];
                }
                nums[j+1]=temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{49,38,65,97,76,13,27,49,55,4};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
