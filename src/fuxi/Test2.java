package fuxi;

/**
 * ClassName:Test1
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/4 10:30
 * @Version 1.0
 */
public class Test2 {
    public static int beibao(int n){
        int nums=n/2+1;
        int[][] dp=new int[nums+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]=Integer.MAX_VALUE-1;
            }
        }
        dp[0][0]=0;
        for (int i = 1; i <= nums; i++) {
            for (int j = 0; j <= n; j++) {
                if (j<i*i){
                    dp[i][j]=dp[i-1][j];

                }
                else {
                    //System.out.println(j);
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-i*i]+1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.print("\n");
        }
        return dp[nums][n];
    }

    public static void main(String[] args) {
        System.out.println(beibao(12));
    }
}
