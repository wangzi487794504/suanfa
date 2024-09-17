package dynamic;

/**
 * ClassName:CoinChange
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/13 14:31
 * @Version 1.0
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                if (dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1 );
                }
            }
        }
        if (dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
