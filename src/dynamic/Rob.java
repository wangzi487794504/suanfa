package dynamic;

import partten.template.DesignPatternClass;

import java.util.Arrays;

/**
 * ClassName:Rob
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/14 17:07
 * @Version 1.0
 */
public class Rob {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]= nums[0];
        if (nums.length<=1){
            return dp[0];
        }
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= i; j--) {
                dp[j]=Math.max(dp[j-2]+nums[i],dp[j-1]);
            }
        }
        return dp[nums.length-1];
    }
    public int rob2(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]= nums[0];
        if (nums.length<=1){
            return dp[0];
        }
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);

        }
        return dp[nums.length-1];
    }
}
