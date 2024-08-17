package dynamic;

/**
 * ClassName:UniquePathsWithObstacles
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/19 16:23
 * @Version 1.0
 */
public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //todo ，新建一个二维数组
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        //todo 书写递推公式
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i==0 || j==0){
                    if (obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }
                    else {
                        //这里也有可能堵住
                        if (j!=0){
                            dp[i][j]=dp[i][j-1];
                        }
                        else if(i!=0){
                            dp[i][j]=dp[i-1][j];
                        }
                        else {
                            dp[i][j]=1;
                        }
                    }
                }
                else {
                    if (obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }
                    else {
                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    }
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}
