package dynamic;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * ClassName:LastStoneWeightII
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/11 16:57
 * @Version 1.0
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        //先求平均值,找到一个集合能够接近平均值的
        int target = Arrays.stream(stones).sum()/2;
        System.out.println(target);
        //定义dp，dp表示放的重量
        int[] dp=new int[target+1];
        dp[0]=0;
        //第一次for循环便利的是物品
        for (int i = 0; i < stones.length; i++) {
            //第二层遍历是背包，物品0在背包容量1为j时的价值
            for (int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        System.out.println(Arrays.stream(stones).sum());
        System.out.println(dp[target]);
        return Arrays.stream(stones).sum()-dp[target]*2;
    }
}
