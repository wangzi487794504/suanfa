package test;

import java.util.ArrayList;

/**
 * ClassName:Test2
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/13 9:32
 * @Version 1.0
 */
public class Test2 {
    public int[] multiply (int[] A) {
        // write code here
        //用空间换时间
        //一个数组存左边，一个数组存右边
        int[] leftA=new int[A.length];
        int[] rightA=new int[A.length];
        //结果数组B
        int[] B=new int[A.length];
        leftA[0]=1;
        for (int i = 1; i < A.length; i++) {
            leftA[i]=leftA[i-1]*A[i-1];
        }
        rightA[A.length-1]=1;
        for (int i = A.length-2; i >=0; i--) {
            rightA[i]=rightA[i+1]*A[i+1];
        }
        for (int i = 0; i < A.length; i++) {
            B[i]=leftA[i]*rightA[i];
        }
        return B;
    }
    public int boxin (int V, ArrayList<Integer> num) {
        // write code here
        //标准的01背包
        int[] dp=new int[V+1];
        //初始化
        dp[0]=0;
        for (int i = 0; i < num.size(); i++) {
            for (int j = V; j >= num.get(i); j--) {
                dp[j]=Math.max(dp[j],dp[j- num.get(i)]+num.get(i) );
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
    }
}
