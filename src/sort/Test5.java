package sort;

import java.util.*;
import java.util.stream.Collectors;


/**
 * ClassName:Test5
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/18 13:43
 * @Version 1.0
 */
public class Test5 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数组长度
        int n=scanner.nextInt();
        if (n<3){
            System.out.println(0);
            return;
        }
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]= scanner.nextInt();
        }
        int[] lSum=new int[n];
        int[] rSum=new int[n];
        lSum[0]=1;
        for (int i = 1; i < n; i++) {
                if (nums[i]>nums[i-1]){
                    lSum[i]=lSum[i-1]+1 ;
                }
                else {
                    lSum[i]=1 ;
                }
        }
        rSum[n-1]=1;
        for (int i = n-2; i >=0; i--) {
                if (nums[i]>nums[i+1]){
                    rSum[i]=rSum[i+1]+1 ;
                }
                else {
                    rSum[i]=1;
                }
        }
        int length=0;
        for (int i = 1; i < n-1 ; i++) {
            if (lSum[i]>1 && rSum[i]>1){
                length=Math.max(length, lSum[i]+rSum[i]-1);
            }
        }
        System.out.println(length);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //组说
        int T=scanner.nextInt();
        while (T-->0){
            //数量
            int n=scanner.nextInt();
            int target=scanner.nextInt();
            List<Set<String>> groups=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int m= scanner.nextInt();
                Set<String> set=new HashSet<>();
                for (int j = 0; j < m; j++) {
                    set.add(scanner.next());
                }
                groups.add(set);
            }
            boolean result=false;
            //位置记录
            int firstIndex=-1;
            int rightIndex=-1;
            for (int i = 0; i < n; i++) {
                if (result==true){
                    break;
                }
                for (int j = i+1; j < n; j++) {
                    Set<String> combine=new HashSet<>(groups.get(i));
                    combine.addAll(groups.get(j));
                    if (combine.size()==target){
                        result=true;
                        firstIndex=i+1;
                        rightIndex=j+1;
                        break;
                    }
                }
                if (result==true){
                    break;
                }
            }
            if (result){
                System.out.println("YES");
                System.out.println(firstIndex+" "+rightIndex);
            }
            else {
                System.out.println("NO");
            }
        }

    }
    static List<List<Integer>> tree;
    static char[] colors;
    //是否遍历过
    static boolean[] isVisited;
    static int result=0;
    //定义一个技术
    static int[][] dp;
    static int redCount;
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }

       backtracking(nums,0);
        System.out.println(lists);
    }
    static List<Integer> list=new ArrayList<>();
    static List<List<Integer>> lists=new ArrayList<>();
    static void backtracking(int[] nums,int startIndex){
        if (list.size()>= 2){
            lists.add(new ArrayList<>(list));
        }
        for (int i = startIndex; i < nums.length ; i++) {
            if (list.size()==0){
                list.add(nums[i]);
            }
            else {
                if (nums[i]<list.get(list.size()-1)){
                    continue;
                }
                else {
                    list.add(nums[i]);
                }
            }
            backtracking(nums, i+1);
            list.remove(list.size()-1);
            while (i!= nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }
    }

    // 10 1 2 7 6 1 5   5 5 5 5 5


}
