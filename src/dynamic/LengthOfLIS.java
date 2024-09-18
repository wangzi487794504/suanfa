package dynamic;

import java.util.Arrays;

/**
 * ClassName:LengthOfLIS
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/18 17:12
 * @Version 1.0
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[]dp=new int[nums.length];
        //0是选
        dp[0]=1;
        Arrays.fill(dp, 1);
        int result=0;
        for (int i = 1; i < nums.length; i++) {
            //选中的情况下
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            result=Math.max(result, dp[i]);
        }
        return result;
    }
}
