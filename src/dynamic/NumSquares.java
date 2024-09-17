package dynamic;

/**
 * ClassName:NumSquares
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/13 14:58
 * @Version 1.0
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[1]=1;
        int[] nums=new int[(int) Math.sqrt(n)+1];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i * i; j < dp.length; j++) {
                if (dp[j-i]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-i * i]+1);
                }
            }
        }
        return dp[n];
    }
}
