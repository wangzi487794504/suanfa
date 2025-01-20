package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName:Test1
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/19 0:04
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        int panduan = panduan(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        System.out.println(panduan);
    }

    /**
     * 删除字符串中所有相邻且相同的字符对
     * @param s 输入的字符串
     * @return 删除后的字符串
     */
    public static String removeDuplicates(String s) {
        // 使用StringBuilder作为栈的替代
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) { // 逐字符遍历输入字符串
            // 检查StringBuilder是否为空，以及最后一个字符是否与当前字符相同
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1); // 删除最后一个字符（相同字符对被删除）
            } else {
                sb.append(c); // 添加当前字符到StringBuilder
            }
        }
        return sb.toString(); // 返回结果字符串
    }
    public static int panduan(String[] nums,int m,int n){
        int dp[][]=new int[m+1][n+1];
        //初始化
        for (int i = 0; i < nums.length; i++) {
            //拿到这个物品的0数量和1数量
            int first=0;
            int zero=0;
            for (char c : nums[i].toCharArray()) {
                if (c=='0'){
                    zero++;
                }
                else {
                    first++;
                }
            }
            for (int j = m; j >=zero; j--) {
                for (int k = n; k >= first; k--) {
                    dp[j][k]=Math.max(dp[j][k],dp[j-zero][k-first]+1);
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test2(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
    }

}
class SingleParttern {
    private static volatile SingleParttern singleParttern;

    private SingleParttern() {
        synchronized (this) {
            if (singleParttern != null) {
                System.out.println("不允许反射创建");
            }
        }
    }

    public static SingleParttern getInstance() {
        //双重检查
        if (singleParttern == null) {
            synchronized (SingleParttern.class) {
                if (singleParttern == null) {
                    singleParttern = new SingleParttern();
                }
            }
        }
        return singleParttern;
    }

    //    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        //两个整数
//        int n=scanner.nextInt();
//        int k=scanner.nextInt();
//        //定义一个数组
//        int[] nums=new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]= scanner.nextInt();
//        }
//        long result=max(n,k,nums);
//        System.out.println(result);
//    }
    public static long max(int n, int k, int[] nums) {
        int[] gcdArray = new int[n - 1];
        long[] sum = new long[n];
        for (int i = 0; i < n - 1; i++) {
            int temp = gcd(nums[i], nums[i + 1]);
            if (temp > Math.sqrt(k) && (k % temp != 0 || temp <= Math.sqrt(k))) {
                temp = 0;
            }
            gcdArray[i] = temp;
            sum[i + 1] = sum[i] + temp;
        }
        long maxSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long temp2 = sum[j] - sum[i];
                maxSum = Math.max(maxSum, temp2);
            }
        }
        return maxSum;
    }

    //求公约数
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        //种类数和压岁钱数量
//        int n=scanner.nextInt();
//        int m=scanner.nextInt();
//        //已经有的
//        boolean [] myhave=new boolean[100000001];
//        for (int i = 0; i < n; i++) {
//            int index=scanner.nextInt();
//            myhave[index]= true;
//        }
//        //可以购买的数量
//        int count=0;
//        //i和第i个价格一样
//        for (int i = 1; i <= m; i++) {
//            System.out.println("ii="+i);
//            if (!myhave[i] && m>=i){
//                count++;
//                m-=i;
////                System.out.println("i="+i);
////                System.out.println("m="+m);
//            }
//            //没钱
//            if (m<i){
////                System.out.println("aa");
//                break;
//            }
//        }
//        System.out.println(count);
//    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] dp=new int[n+1];
        //组合
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i>j){
                    dp[i]=dp[i]+dp[i-j];
                }
            }
        }
        System.out.println(dp[n]);
    }
    public static int lingqian(int[] nums,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                for (int k = 1; k <= j/nums[i]; k++) {
                        dp[j]+=dp[j-k*nums[i]];
                }
            }
        }
        return dp[target];
    }
    public int combinationSum4(int[] nums, int target) {
        //TODO 定义一个金额数组
        //递推公式dp[j]=max(dp[j],dp[i-k*value[i]]+k*value[i])
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 0; i <nums.length; i++) {
            for (int j = nums[i]; j <=target; j++) {
                    dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }

}
//public class Main{
//
//}
