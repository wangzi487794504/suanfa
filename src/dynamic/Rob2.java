package dynamic;

import java.util.Arrays;

/**
 * ClassName:Rob2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 17:40
 * @Version 1.0
 */
public class Rob2 {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]= nums[0];
        if (nums.length<=1){
            return dp[0];
        }
        dp[1] = Math.max(dp[0], nums[1]);
        int a=extracted(Arrays.copyOfRange(nums, 0, nums.length-1), dp);
        int b=extracted(Arrays.copyOfRange(nums, 1, nums.length), dp);
        return a>b ? a:b;
    }

    private static int extracted(int[] nums, int[] dp) {
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-2]+ nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
