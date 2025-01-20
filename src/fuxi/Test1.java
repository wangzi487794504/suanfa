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
public class Test1 {
    public static int beibao(int[] nums){
        int index=nums.length/2+1;
        int[][] dp=new int[nums.length+1][index+1];
        //选第一个物品
        for (int i = 0; i <= index; i++) {
            dp[1][i]=nums[0];
        }
        //有两个物品的时候
        for (int i = 2; i <= nums.length; i++) {
            //i-1是第i个物品
            for (int j = index; j >= 1; j--) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i-2][j-1]+nums[i-1] );
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.print("\n");
        }
        return dp[nums.length][index];
    }

    public static void main(String[] args) {
        System.out.println(beibao(new int[]{1,2,3,1}));
    }
}
