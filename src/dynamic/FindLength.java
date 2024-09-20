package dynamic;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;

/**
 * ClassName:FindLength
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/18 21:02
 * @Version 1.0
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        //初始化
        dp[0][0]= nums1[0]==nums2[0]? 1 :0;
        // todo第一种 当i为0时
        for (int i = 1; i <nums2.length; i++) {
            dp[0][i]= nums1[0]==nums2[i]? 1 : dp[0][i-1];
        }
        // todo第一种 当j为0时
        for (int i = 1; i <nums1.length; i++) {
            dp[i][0]= nums1[i]==nums2[0]? 1 :dp[i-1][0];
        }
        // todo第一种 当i,j都不为0时
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                //还是这三种情况
                //i可能包含，j不包含
                //j,i
                //j 和i都包含
                dp[i][j]=Math.max(dp[i][j-1],Math.max(dp[i-1][j],nums1[i]==nums2[j]? 1+dp[i-1][j-1]:0));
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.print("\n");
        }
        return dp[nums1.length-1][nums2.length-1];
    }

    public static void main(String[] args) {
        int length = new FindLength().findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1});
        System.out.println(length);
    }
}
