package dynamic;

import java.util.Scanner;

/**
 * ClassName:Mian6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/22 15:28
 * @Version 1.0
 */
public class Mian6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            nums[i]= scanner.nextInt();
            sum+=nums[i];
        }
        //木匾就是一半
        boolean[] dp=new boolean[sum/2+1];
        dp[0]=true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum/2; j >=nums[i] ; j--) {
                dp[j] |=dp[j-nums[i]];
            }
        }
        for (int i = sum/2; i >=0; i--) {
            if (dp[i]){
                System.out.println(sum-2*i);
                break;
            }
        }
    }
}
