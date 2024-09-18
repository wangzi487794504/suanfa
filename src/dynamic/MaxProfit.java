package dynamic;

/**
 * ClassName:MaxProfit
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/17 21:22
 * @Version 1.0
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int low=Integer.MAX_VALUE;
        int result=0;
        for (int i = 0; i < prices.length; i++) {
            low=Math.min(low,prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
    public int maxProfit2(int[] prices) {
        int[][] dp=new int[prices.length][2];
        //初始化
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            //i 0是第i天股票在手里时的利润，1是股票不在手里时的利润
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}
