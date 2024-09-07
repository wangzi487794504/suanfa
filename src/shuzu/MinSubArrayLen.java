package shuzu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * ClassName:MinSubArrayLen
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 15:47
 * @Version 1.0
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums){
        int result=nums.length+1;
        //连续的就使用双指针
        int left=0;
        int right=0;
        int sum=0;
        for (right = 0; right < nums.length; right++) {
            sum+=nums[right];
            while (sum>=target){
                if (result>=right-left+1){
                    result=right-left+1;
                }
                sum-=nums[left];
                left++;
            }
        }
        if (result==nums.length+1){
            return 0;
        }
        return result;
    }
    //这种找到的不是连续子数组
    public int minSubArrayLen2(int target, int[] nums) {
        //思路：先排序，从大到小
        Arrays.sort(nums);
        reverse(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        //开始从第一个元素走
        for (int i = 0; i < nums.length; i++) {
            target-=nums[i];
            if (target<=0){
                return i+1;
            }
        }
        return 0;
    }
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // 交换元素
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
}
