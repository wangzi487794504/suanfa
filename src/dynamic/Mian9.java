
package dynamic;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
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
public class Mian9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //组数
        long  n=scanner.nextInt();
        long m=scanner.nextInt();
//        int[] a=new int[m];
        List<Long> list=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add((long) scanner.nextInt());
//            a[i]= scanner.nextInt();
        }
        long minSum=Long.MAX_VALUE;
        long minPosition=1;
        for (long j = 1; j <= n; j++) {
            long currentSum=0;
            for (long i = 0; i < m; i++) {
//                int dis1=Math.abs(a[i]-j);
                long dis1=Math.abs(list.get((int) i)-j);
                long dis2=n-dis1;
                currentSum+=Math.min(dis1, dis2);

            }
            if (minSum>currentSum){
                minSum=currentSum;
                minPosition=j;
            }
        }
        System.out.println(minPosition);
    }
}
