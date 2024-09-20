package dynamic;

import java.util.Scanner;

/**
 * ClassName:Main
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 15:54
 * @Version 1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //数据组数
        int T = scanner.nextInt();
        while (T-->0){
            //数组长度
            int N = scanner.nextInt();
            int[] nums1=new int[N];
            int[] nums2=new int[N];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i]= scanner.nextInt();
            }
            for (int i = 0; i < nums2.length; i++) {
                nums2[i]= scanner.nextInt();
            }
            System.out.println(check(nums1, nums2, N)? "YES":"NO");
        }
        scanner.close();
    }

    private static boolean isOrder(int[] x,int[] y,int n,boolean ascending){
        boolean swapped=false;
        int prev=ascending ?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentX=x[i];
            int currentY=y[i];
            if (swapped){

                int temp=currentX;
                currentX=currentY;
                currentY=temp;
            }
            if (ascending){
                if (currentX>prev){
                    prev=currentX;
                }
                else {
                    if (currentY>prev &&currentY>=x[i]){
                        swapped=!swapped;
                        prev=currentY;
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                if (currentX<=prev){
                    prev=currentX;
                }
                else {
                    if (currentY<=prev &&currentY<=x[i]){
                        swapped=!swapped;
                        prev=currentY;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean check(int[] a,int[] b,int n){
        return isOrder(a,b,n, true)||isOrder(a,b,n, false)||isOrder(b,a,n, true)||isOrder(b,a,n, false);
    }
}
