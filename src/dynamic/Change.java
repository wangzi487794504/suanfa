package dynamic;

/**
 * ClassName:Change
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/13 9:49
 * @Version 1.0
 */
public class Change {
    public int change(int amount, int[] coins) {
        //TODO 定义一个金额数组
        //递推公式dp[j]=max(dp[j],dp[i-k*value[i]]+k*value[i])
        int[] target=new int[amount+1];
        target[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < target.length; j++) {
                target[j]+=target[j-coins[i]];
            }
        }
        return target[amount];
    }
    public int change2(int amount, int[] coins) {
        //TODO 定义一个金额数组，一个硬币的重量和金额应该一样
        //递推公式dp[j]=max(dp[j],dp[i-k*value[i]]+k*value[i])
        int[] target=new int[amount+1];
        target[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = target.length-1; j >=coins[i] ; j--) {
                //增加一个最多能放多少个i的循环
                for (int k = 1; k <= j/coins[i]; k++) {
                    System.out.println("执行");
                    //这样球的，是价值最大，我们应该求长度
                    target[j]+=target[j-k*coins[i]];
                }
            }
        }
        return target[amount];
    }
}
