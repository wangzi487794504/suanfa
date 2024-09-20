package dynamic;

/**
 * ClassName:NumDistinct
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 15:27
 * @Version 1.0
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[t.length()][s.length()];
        //初始化
        //初始化
        //循环
        if (t.length()>s.length()){
            return 0;
        }
        char[] charArray = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        dp[0][0]=charArray[0]==charArray2[1]? 1: 0;
        for (int i = 0; i < s.length(); i++) {
            dp[0][i]=charArray[i]==charArray2[0]? 1+dp[i][i-1]:dp[0][i-1];
        }
        for (int i = 1; i < t.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (charArray[j]==charArray2[i]){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }
                else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[t.length()-1][s.length()-1];
    }
}
