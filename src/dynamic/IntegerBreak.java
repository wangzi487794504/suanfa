package dynamic;

/**
 * ClassName:IntegerBreak
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/19 17:13
 * @Version 1.0
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[2] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i-j; j++) {
                //dp[i-j]代表可拆分,dp[i]表示目前保存的dp[i]最大值
                dp[i]=Math.max(Math.max((i-j)*j,j*dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}
