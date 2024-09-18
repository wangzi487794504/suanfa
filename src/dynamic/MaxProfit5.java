package dynamic;

/**
 * ClassName:MaxProfit5
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/18 15:44
 * @Version 1.0
 */
public class MaxProfit5 {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][4];
        //第一种状态  手上有股票
        dp[0][0]=-prices[0];
        //第二种状态 手上没有股票保持卖出状态
        dp[0][1]=0;
        //第三种  冷冻期
        dp[0][2]=0;
        //第四种 卖出
        dp[0][3]=0;
        for (int i = 1; i < prices.length; i++) {
            int temp=Math.max(dp[i-1][2]-prices[i],dp[i-1][1]-prices[i]);
            dp[i][0]=Math.max(dp[i-1][0], temp);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2]=dp[i-1][3];
            dp[i][3]=dp[i-1][0]+prices[i];
        }
        return Math.max(dp[dp.length-1][3],Math.max(dp[dp.length-1][2], dp[dp.length-1][1]));
    }
}
