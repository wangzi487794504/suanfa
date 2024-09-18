package dynamic;

/**
 * ClassName:MaxProfit4
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/18 11:09
 * @Version 1.0
 */
public class MaxProfit4 {
    public int maxProfit(int k,int[] prices) {

        int[][] dp=new int[prices.length][2*k+1];
        for (int i = 0; i < 2*k+1; i++) {
            if (i%2==0){
                dp[0][i]=0;
            }
            else {
                dp[0][i]=-prices[0];
            }
        }
        System.out.println(dp[0][1]);
        for (int i = 1; i < prices.length; i++) {
            //第一种没有实际意义
            dp[i][0]=dp[i-1][0];
            for (int j = 1; j < 2*k+1; j++) {
                System.out.println(j);
                System.out.println((int) Math.pow(-1,j ));
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+(int) Math.pow(-1,j )*prices[i]);
            }
        }
        return dp[prices.length - 1][2*k];
    }
    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        // 如果 k 超过了交易的上限，则其实可以进行无限次交易
        if (k >= prices.length / 2) {
            int totalProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    totalProfit += prices[i] - prices[i - 1];
                }
            }
            return totalProfit;
        }

        int[][] dp = new int[prices.length][2 * k + 1];

        for (int i = 0; i < 2 * k + 1; i++) {
            dp[0][i] = (i % 2 == 1) ? -prices[0] : 0;
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0]; // 前一天的“无交易”状态
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1) {
                    // 持有股票，买入
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    // 持有现金，卖出
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][2 * k]; // 只考虑最后持有现金的状态
    }
}
