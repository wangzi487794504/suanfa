package dynamic;

/**
 * ClassName:MaxProfit3
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/17 23:10
 * @Version 1.0
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][5];
        //初始化，五种状态
        //第一种，什么都不操作
        dp[0][0]=0;
        //第二种，第一次持有
        dp[0][1]=-prices[0];
        //第三种，第一次不持有
        dp[0][2]=0;
        //第四种，第两次持有
        dp[0][3]=-prices[0];
        //第五种，第两次不持有
        dp[0][4]=0;
        for (int i = 1; i < prices.length; i++) {
            //第一种没有实际意义
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
