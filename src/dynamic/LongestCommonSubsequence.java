package dynamic;

import org.omg.CORBA.INTERNAL;

/**
 * ClassName:LongestCommonSubsequence
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 9:23
 * @Version 1.0
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        char[] charArray = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        dp[0][0]=charArray[0]==charArray2[0]? 1:0;
        //初始化d[i][0]
        for (int i = 1; i < charArray.length; i++) {
            dp[i][0]=charArray2[0]==charArray[i]? 1:dp[i-1][0];
        }
        //初始化d[0][i]
        for (int i = 1; i < charArray2.length; i++) {
            dp[0][i]=charArray2[i]==charArray[0]? 1:dp[0][i-1];
        }
        for (int i = 1; i < charArray.length; i++) {
            for (int j = 1; j < charArray2.length; j++) {
                //三种情况，一个是可能有i，没有j   有j无i，j和i都有
                dp[i][j]=Math.max(dp[i][j-1], Math.max(dp[i-1][j],charArray[i]==charArray2[j]? 1+dp[i-1][j-1]:dp[i-1][j-1]));
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[charArray.length-1][charArray2.length-1];
    }

    public static void main(String[] args) {
        new LongestCommonSubsequence().longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr");
    }
}
