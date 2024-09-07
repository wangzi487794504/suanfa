package dynamic;

/**
 * ClassName:NumTrees
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/4 9:29
 * @Version 1.0
 */
public class NumTrees {
    public int numTrees(int n) {
        //先初始化dp数组
        int[] dp=new int[n+1];
        dp[0]=1;
        //确定递推公式
        //todo 每个n的数量等于0-n作为树的头结点之和
        //todo 对于n,如果头结点确定为i，则左边最多为i-1，右边为n-i，所以对于头结点为i的时候，总个数为dp[i-1]*dp[n-i]
        //todo 为0的时候也是1，一直取到n
        for (int i = 1; i <= n; i++) {
            //确定j之后，j可以取到i
            for (int j = 1; j <= i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }
}
