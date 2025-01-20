package sort;

import java.util.Arrays;

/**
 * ClassName:Test4
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/17 19:56
 * @Version 1.0
 */
public class Test4 {
    public static long solve2 (int[] A) {
        // write code here
        //三个最大的正数
        //两个最小的负数和一个最大的正数
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        for (int i : A) {
            if (i>max1){
                //保证前三个最大的
                max3=max2;
                max2=max1;
                max1=i;
            }
            else if (i>max2){
                max3=max2;
                max2=i;
            }
            else if (i>max3){
                max3=i;
            }
            if (i<min1){
                min2=min1;
                min1=i;
            }
            else if (i<min2){
                min2=i;
            }
        }
        System.out.println("a"+max1);
        System.out.println(max1);
        System.out.println(max1);
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
    public static long solve (int[] A) {
        // write code here
        //三个最大的正数
        //两个最小的负数和一个最大的正数
        Arrays.sort(A);
        return Math.max(A[0]*A[1]*A[A.length-1],A[A.length-1]*A[A.length-2]*A[A.length-3]);
    }
    public static void main(String[] args) {
        int[] n=new int[]{3,4,1,2};
        System.out.println(solve(n));
    }
}
