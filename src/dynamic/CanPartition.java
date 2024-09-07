package dynamic;

import java.util.Arrays;

/**
 * ClassName:CanPartition
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 14:26
 * @Version 1.0
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        //todo 找到两个不同的集合的value相等，要满足nums的和/2=target，而只要有集合是满足target的，那么就能找打到集合满足
        //求和
        int sum = Arrays.stream(nums).sum();
        int target=sum/2;
        if(sum % 2 != 0) {
            return false;
        }
        int[] dp=new int[target+1];
        //todo 此时应该转为背包问题 num[i-1][j]==num[i-1][j-wi]+vi
        //初始化
        //此时物品的价值和背包的容量是一样的
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if(dp[target] == target){
                return true;
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {

    }
}
