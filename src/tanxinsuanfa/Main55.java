package tanxinsuanfa;

import test.A;

import java.util.*;

/**
 * ClassName:Main
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/21 16:25
 * @Version 1.0
 */
public class Main55 {
//    public static void main(String[] args) {
//        //输入
//        Scanner scanner = new Scanner(System.in);
//        //木棍数量
//        int num=scanner.nextInt();
//        //移动次数
//        int k= scanner.nextInt();
//        //维护一个数组
//        int[] zhuzi=new int[num];
//        //保存对象
//        for (int i = 0; i < num; i++) {
//            zhuzi[i]= scanner.nextInt();
//        }
//        //排序
//        Arrays.sort(zhuzi);
//        int[] result=new int[num];
//        //双指针
//        int left=0;
//        int right=num-1;
//        for (int i = 0; i < num; i++) {
//            if (i<num-k){
//                result[left++]=zhuzi[i];
//            }
//            else {
//                result[right--]=zhuzi[i];
//            }
//        }
//        for (int i = 0; i < num; i++) {
//            System.out.println(result[i]);
//            if (i<num-1){
//                System.out.println(" ");
////            }
////        }
////    }
    static int num;
    static int[] numsA;
    static int[] numsB;
//    static Set<Integer> results=new HashSet<>();
//    public static void main(String[] args) {
//        //输入
//        Scanner scanner = new Scanner(System.in);
//        //木棍数量
//        num=scanner.nextInt();
//        numsA=new int[num];
//        numsB=new int[num];
//        for (int i = 0; i < num; i++) {
//            numsA[i]= scanner.nextInt();
//        }
//        for (int i = 0; i < num; i++) {
//            numsB[i]= scanner.nextInt();
//        }
//        backtracking(0, numsA, numsB);
//        System.out.println(results.size());
//    }
//    static void backtracking(int index,int[]tempA,int[] tempB){
//        if (index==num){
//            int result=calResult(tempA, tempB);
//            results.add(result);
//            return;
//        }
//        int[] newA =Arrays.copyOf(tempA, num);
//        int[] newB =Arrays.copyOf(tempB, num);
//        backtracking(index+1, newA, newB);
//        newB[index]=newA[index];
//        backtracking(index+1, newA, newB);
//        newA[index]=newB[index];
//        backtracking(index+1, newA, newB);
//    }
//    static int calResult(int[] tempA,int[] tempB ){
//        int sum=0;
//        for (int i = 0; i < num; i++) {
//            sum+=tempA[i]*tempB[i];
//        }
//        System.out.println("sum"+sum);
//        return sum;
//    }
//    public static void main(String[] args) {
//        //输入
//        Scanner scanner = new Scanner(System.in);
//        //木棍数量
//        num=scanner.nextInt();
//        numsA=new int[num];
//        numsB=new int[num];
//        for (int i = 0; i < num; i++) {
//            numsA[i]= scanner.nextInt();
//        }
//        for (int i = 0; i < num; i++) {
//            numsB[i]= scanner.nextInt();
//        }
//        int[][] dp=new int[num+1][num+1];
//        dp[0][0]=1;
//        for (int i = 0; i <= num; i++) {
//            for (int j = 0; j <= num; j++) {
//                if (i<num){
//                    dp[i+1][j+1]+=dp[i][j];
//                }
//                if (j>0){
//                    dp[i][j-1]+=dp[i][j]*numsB[num-j];
//                }
//            }
//        }
//        System.out.println(dp[num][0]);
//    }
public static void main(String[] args) {
    //输入
    Scanner scanner = new Scanner(System.in);
    //木棍数量
    num=scanner.nextInt();
    numsA=new int[num];
    numsB=new int[num];
    for (int i = 0; i < num; i++) {
        numsA[i]= scanner.nextInt();
    }
    for (int i = 0; i < num; i++) {
        numsB[i]= scanner.nextInt();
    }
    Stack<Integer> stack=new Stack<>();
    int result=dfs(numsA,numsB,stack,0,0,0);
    System.out.println(result);
}
    private static int dfs(int[] numsA, int[] numsB, Stack<Integer> stack, int count, int sum,int index) {
        if (count==2*numsA.length){
            return sum;
        }
        int totalSum=0;
        if (index<numsA.length){
            stack.push(numsA[index]);
            dfs(numsA, numsB, stack, index+1, count+1, sum);
        }
        if (!stack.isEmpty()){
            int top=stack.pop();
            sum+=dfs(numsA, numsB, stack, index, count+1, top*numsB[top-1]);
            stack.push(top);
        }
        return sum;
    }
}
