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
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //数据组数
        int T = scanner.nextInt();
        while (T-->0){
            //容量
            int N = scanner.nextInt();
            //数量
            int n=scanner.nextInt();
            //填充物
            int s=scanner.nextInt();
            int[] toys=new int[n];
            for (int i = 0; i < toys.length; i++) {
                toys[i]=scanner.nextInt();
            }
            boolean[] dp=new boolean[N+1];
            dp[0]=true;
            for (int toy : toys) {
                for (int i = N; i >= toy; i--) {
                    if (dp[i-toy]){
                        dp[i]=true;
                    }
                }
            }
            if (dp[N]){
                System.out.println("YES");
            }
            else {
                int needSpace=0;
                for (int i = N; i >= 0; i--) {
                    if (dp[i]){
                        needSpace=N-i;
                        break;
                    }
                }
                if (s>=needSpace){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
        scanner.close();
    }
}
