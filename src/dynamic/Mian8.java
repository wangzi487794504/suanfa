package dynamic;

import java.util.*;

/**
 * ClassName:Mian6
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/22 15:28
 * @Version 1.0
 */
public class Mian8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //组数
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] a=new int[m];
        for (int i = 0; i < m; i++) {
            a[i]= scanner.nextInt();
        }
        int[] diff=new int[2*n+2];
        for (int i = 0; i < m; i++) {
            int pos=a[i];
            diff[i]+=1;
            diff[pos+1]-=1;
            diff[pos]+=n;
            diff[pos+n]-=n;
            diff[pos+1]+=1;
            diff[2*n+1]-=1;
        }
        int[] sum=new int[2*n+1];
        for (int i = 1; i <= 2 * n; i++) {
            sum[i]=sum[i-1]+diff[i];
        }
        int minSum=Integer.MAX_VALUE;
        int minPosition=0;
        for (int i = 1; i <= n; i++) {
            if (sum[i]>minSum){
                minSum=sum[i];
                minPosition=i;
            }
        }
        System.out.println(minPosition);
    }
}
