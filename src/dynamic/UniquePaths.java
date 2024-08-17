package dynamic;

/**
 * ClassName:UniquePaths
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/19 16:04
 * @Version 1.0
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        //todo ，新建一个二维数组
        int dp[][]=new int[m][n];
        //todo 书写递推公式
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0){
                    dp[i][j]=1;
                }
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
//        System.out.println(uniquePaths(3, 7));
        int[][] aa=new int[2][3];
        System.out.println(aa[0].length);
    }
}
