package dynamic;

/**
 * ClassName:CombinationSum4
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/13 11:13
 * @Version 1.0
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        //TODO 定义一个金额数组
        //递推公式dp[j]=max(dp[j],dp[i-k*value[i]]+k*value[i])
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i>=nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
