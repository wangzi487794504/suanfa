package dynamic;

/**
 * ClassName:MaxUncrossedLines
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 10:10
 * @Version 1.0
 */
public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];

        dp[0][0]=nums1[0]==nums2[0]? 1:0;
        //初始化d[i][0]
        for (int i = 1; i < nums1.length; i++) {
            dp[i][0]=nums2[0]==nums1[i]? 1:dp[i-1][0];
        }
        //初始化d[0][i]
        for (int i = 1; i < nums2.length; i++) {
            dp[0][i]=nums2[i]==nums1[0]? 1:dp[0][i-1];
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                //三种情况，一个是可能有i，没有j   有j无i，j和i都有
                dp[i][j]=Math.max(dp[i][j-1], Math.max(dp[i-1][j],nums1[i]==nums2[j]? 1+dp[i-1][j-1]:dp[i-1][j-1]));
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}
