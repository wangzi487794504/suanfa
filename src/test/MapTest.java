package test;

import lianbiao.ListNode;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.management.GarbageCollectorMXBean;
import java.util.*;

/**
 * ClassName:MapTest
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/11 9:08
 * @Version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] shuru=null;
        System.out.println(s.length());
        System.out.println(s);
        if (s!=null ||s!="" || s.length()!=0 || s!=" "){
            shuru=s.split(" ");
        }
        else {
            System.out.println(0);
        }
        int[] biaozhi=new int[21];
        for (int i = 0; i < shuru.length; i++) {
            biaozhi[Integer.parseInt(shuru[i])+10]+=1;
        }
        int result=0;
        for (int i = 0; i < biaozhi.length; i++) {
            if (biaozhi[i]>result){
                result=biaozhi[i];
            }
        }
        if (result<=shuru.length-3){
            System.out.println(result+3);
        }
        else {
            System.out.println(shuru.length);
        }

    }

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n= scanner.nextInt();
//        int k= scanner.nextInt();
//        int[][] items=new int[n][2];
//        for (int i = 0; i < n; i++) {
//            items[i][0]= scanner.nextInt();
//            items[i][1]= scanner.nextInt();
//        }
//        System.out.println(max(items, k));
//    }
    public static int max(int[][] items,int k){
        Arrays.sort(items,(a,b)-> b[0]-a[0]);
        PriorityQueue<Integer> profit=new PriorityQueue<>();
        Set<Integer> cat=new HashSet<>();
        int total=0;
        for (int i = 0; i < items.length; i++) {
            if (i<k){
                profit.offer(items[i][0]);
                cat.add(items[i][1]);
                total+=items[i][0];
            }
            else if(!cat.contains(items[i][1])){
                if (profit.peek()<items[i][0]){
                    total=total-profit.poll()+items[i][0];
                    profit.offer(items[i][0]);
                    cat.add(items[i][1]);
                }
            }
        }
        return (total+cat.size()* cat.size());
    }
//    public static int max2(int[][] items,int k){
//        int[][] dp=new int[k][2];
//        for (int i = 0; i < items.length; i++) {
//            for (int j=k-1;k>=0;k--){
//                dp[i][j]=Math.max(dp[i-1][k],dp[i][k-1]+)
//            }
//        }
//    }
}
