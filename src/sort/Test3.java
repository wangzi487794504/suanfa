package sort;

import java.util.*;

/**
 * ClassName:Test3
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/16 19:20
 * @Version 1.0
 */
public class Test3 {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T= scanner.nextInt();
        while (T-->0){
            //这里是字符串
            int n= scanner.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            int[] c=new int[n];
            int[] d=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=scanner.nextInt();
                b[i]=scanner.nextInt();
                c[i]=scanner.nextInt();
                d[i]=scanner.nextInt();
            }
            //dp数组
            int[][] dp=new int[n][2];
            dp[0][0]=a[0];
            dp[0][1]=c[0];
            for (int i = 1; i < n; i++) {
                //0选左
                dp[i][0]=Math.max(dp[i-1][0]+a[i],dp[i-1][1]+a[i]-d[i]);
                dp[i][1]=Math.max(dp[i-1][1]+c[i],dp[i-1][0]+c[i]-b[i]);
            }
            System.out.println(Math.max(dp[n-1][1],dp[n-1][0]));
        }
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T= scanner.nextInt();
        while (T-->0){
            //组数
            int n= scanner.nextInt();
            //定义一个boolean看看有没有出现
            List<boolean[]> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boolean[] dig=new boolean[10];
                for (int j = 0; j < 6; j++) {
                    dig[scanner.nextInt()]=true;
                }
                list.add(dig);
            }
            //有的就是出现过一次，找第一个没有出现的
            int[] nums=new int[10];
            for (int i = 0; i < list.size(); i++) {
                boolean[] temp=list.get(i);
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j]==true){
                        nums[j]++;
                    }
                }
            }
            //就是所有数字组合能够出现的次数
            int min=Integer.MAX_VALUE;
            int index=50;
            boolean zer=false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0 && i==0){
                    continue;
                }
                //找最小的
                if (nums[i]==0 && i!=0){
                    index=i;
                    zer=true;
                    break;
                }
                if (min>nums[i]){
                    min=nums[i];
                    index=i;
                }
            }
            if (zer){
                System.out.println(index);
            }
            else {
                if (nums[0]<=min){
                    int a=nums[0];
                    while (a-->=0){
                        index=index*10;
                    }
                    System.out.println(index);
                }
                else {
                    int a=index;
                    while (min-->=0){
                        index=index*10+a;
                    }
                    System.out.println(index);
                }
            }
        }
        scanner.close();
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T= scanner.nextInt();
        while (T-->0){
            //组数
            int n= scanner.nextInt();
            //定义一个boolean看看有没有出现
            Set<Integer> nums=new HashSet<>();
            possilble(scanner, n, nums);
            int minNum=1;
            while (nums.contains(minNum)){
                minNum++;
            }
            System.out.println(minNum);
        }
        scanner.close();
    }
    public static void possilble(Scanner scanner,int n,Set<Integer> nums){
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                list.add(scanner.nextInt());
            }
            lists.add(list);
        }
        generate(lists,0,0,nums);
    }

    private static void generate(List<List<Integer>> lists, int index, int cur, Set<Integer> nums) {
        if (index==lists.size()){
            if (cur>0){
                nums.add(cur);
            }
            return;
        }
        for (Integer num : lists.get(index)) {
            generate(lists, index+1, cur*10+num, nums);
        }
        generate(lists, index+1, cur, nums);
    }
}
