package dynamic;

/**
 * ClassName:MinCostClimbingStairs
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/19 15:11
 * @Version 1.0
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        //todo 确定dp数组和下标意义 在本题中，为达到第n个阶最小花费
        int[] dp=new int[cost.length+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        //todo 确定递推公式
        for (int i = 2; i < cost.length; i++) {
            dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        System.out.println(dp[2]);
        return Math.min(dp[cost.length-2],dp[cost.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
