package dynamic;

/**
 * ClassName:MaxProfit6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/18 16:41
 * @Version 1.0
 */
public class MaxProfit6 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][3];
        //两种状态
        //在手里
        dp[0][0]=-prices[0];
        //卖出
        dp[0][1]=0;
        //卖出且保持
        dp[0][2]=0;
        for (int i = 1; i < prices.length; i++) {
            //在手里 上一个在手里
            dp[i][0]=Math.max(dp[i-1][0], Math.max(dp[i-1][1]-prices[i],dp[i-1][2]-prices[i]));
            //卖出
            dp[i][1]=dp[i-1][0]+prices[i]-fee;
            //上一个状态是卖出，或者上一个状态是保持
            dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][0], Math.max(dp[prices.length-1][1],dp[prices.length-1][2]));
    }
}
