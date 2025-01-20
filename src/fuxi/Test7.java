package fuxi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * ClassName:Test7
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/10/10 10:03
 * @Version 1.0
 */
public class Test7 {
    public static void main2(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //糖果的数量,这里长度较大
        //long n= scanner.nextLong();
        String num=scanner.nextLine();
        BigInteger bigInteger=new BigInteger(num);
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            System.out.println(0);
            return;
        }
        //System.out.println(bigInteger);
        BigInteger two=new BigInteger("2");
        BigInteger three=new BigInteger("3");
        BigInteger result=new BigInteger("0");
        while (bigInteger.compareTo(BigInteger.ZERO)>0){
            if (bigInteger.mod(two).equals(BigInteger.ZERO)){
                bigInteger=bigInteger.subtract(bigInteger.divide(two).add(BigInteger.ONE));
            }
            else {
                bigInteger=bigInteger.subtract(bigInteger.divide(three).add(BigInteger.ONE));
            }
            result=result.add(BigInteger.ONE);
        }
        System.out.println(result);
        scanner.close();
    }
    //素数
    public static void main3(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //糖果的数量,这里长度较大
        //long n= scanner.nextLong();
        String num=scanner.nextLine();
        BigInteger bigInteger=new BigInteger(num);
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            System.out.println(0);
            return;
        }
        //System.out.println(bigInteger);
        BigInteger two=new BigInteger("2");
        BigInteger three=new BigInteger("3");
        BigInteger result=new BigInteger("0");
        while (bigInteger.compareTo(BigInteger.ZERO)>0){
            if (bigInteger.mod(two).equals(BigInteger.ZERO)){
                bigInteger=bigInteger.subtract(bigInteger.divide(two).add(BigInteger.ONE));
            }
            else {
                bigInteger=bigInteger.subtract(bigInteger.divide(three).add(BigInteger.ONE));
            }
            result=result.add(BigInteger.ONE);
        }
        System.out.println(result);
        scanner.close();
    }
    public static void main6(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //糖果的数量,这里长度较大
        long n= scanner.nextLong();
        long result=0;
        while (n>0){
            if (isPrime(n)){
                n-=(n/2+1);
            }
            else {
                n-=(n/3+1);
            }
            result++;
        }
        System.out.println(result);
        scanner.close();
    }
    //判断不是素数
    public static boolean isPrime(long number){
        if (number<=1){
            return true;
        }
        for (int i=2;i<= Math.sqrt(number);i++){
            if (number%i==0){
                return true;
            }
        }
       return false;
    }
    public static void main5(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int m= scanner.nextInt();
        //动态规划
        //从数组为1的地方存储
        int[] nums=new int[n+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i]= scanner.nextInt();
        }
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        //初始化
        dp[0][0]=0;
        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 1; j < dp.length; j++) {
                int maxGCD=0;
                for (int l=j;l>=1;l--){
                    maxGCD=gcd(maxGCD, nums[l]);
                    dp[j][i]=Math.max(dp[j][i], dp[l-1][i-1]+maxGCD );
                }
            }
        }
        System.out.println(dp[n][m]);
        scanner.close();
    }
    public static int gcd(int a,int b){
        while (b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static void main8(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //糖果的数量,这里长度较大
        int n= scanner.nextInt();
        int q=scanner.nextInt();
        int[] nums=new int[n+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i]= scanner.nextInt();
        }
        //使用前缀和，一个记住活鱼，一个记住与或
        int[] preAnd=new int[n+1];
        int[] preOr=new int[n+1];
        //第一个就等于第一个
        preOr[1]=nums[1];
        preAnd[1]=nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i%2==0){
                preOr[i]=preOr[i-1] | nums[i];
                preAnd[i]=preAnd[i-1] & nums[i];
            }
            else {
                preOr[i]=preOr[i-1] & nums[i];
                preAnd[i]=preAnd[i-1] | nums[i];
            }
        }
        while (q-->0){
            int op =scanner.nextInt();
            int l =scanner.nextInt();
            int r =scanner.nextInt();
            int result=0;
            if (op==1){
                System.out.println(preAnd[r]);
                result=(r-l+1)%2==0 ? preAnd[r]:(preOr[r] & preAnd[l-1]);
            }
            else {
                result=(r-l+1)%2==0 ? preOr[r]:(preAnd[r] | preOr[l-1]);
            }
            System.out.println(result);
        }
        scanner.close();
    }
    public static void main9(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //糖果的数量,这里长度较大
        int n= scanner.nextInt();
        int q=scanner.nextInt();
        int[] nums=new int[n+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i]= scanner.nextInt();
        }
//        //使用前缀和，一个记住活鱼，一个记住与或
//        int[] preAnd=new int[n+1];
//        int[] preOr=new int[n+1];
        //第一个就等于第一个

        while (q-->0){
            int op =scanner.nextInt();
            int l =scanner.nextInt();
            int r =scanner.nextInt();
            int result=nums[l];
            boolean isAnd=(op==1);
            for (int i = l+1; i <= r; i++) {
               if (isAnd){
                   result=result & nums[i];
               }
               else {
                   result=result | nums[i];
               }
               isAnd=!isAnd;
            }
            System.out.println(result);
        }
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //糖果的数量,这里长度较大
        int n= scanner.nextInt();
        int q=scanner.nextInt();
        int[] nums=new int[n+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i]= scanner.nextInt();
        }
        Tree tree=new Tree(nums);

       //线段树
        while (q-->0){
            int op =scanner.nextInt();
            int l =scanner.nextInt();
            int r =scanner.nextInt();
            System.out.println(tree.query(1, 0, n, op, l, r));
        }
        scanner.close();
    }
    static class Tree{
        int n;
        int[] nums;
        int[][] tree;

        public Tree(int[] nums) {
            this.n = nums.length;
            this.nums = nums;
            this.tree = new int[4*n][4];
        }
        void build(int node,int start,int end){
            if (start==end){
                tree[node][0]=nums[start];
                tree[node][1] =nums[start];
                tree[node][2]=nums[start];
                tree[node][3]=nums[start];
                return;
            }
            int mid=(start+end)/2;
            build(2*node, start, mid);
            build(2*node+1, mid, end);
            //合并
            merge(node);
        }
        void merge(int node){
            int left=node*2;
            int right=node*2+1;
            tree[node][0]=tree[left][0] & tree[right][0];
            tree[node][1] =tree[left][1] | tree[right][1];
            tree[node][2]=(tree[left][2] & tree[right][1]) | (tree[left][0] & tree[right][2]);
            tree[node][3]=(tree[left][3] | tree[right][0]) & (tree[left][1] | tree[right][3]);
        }
        //查询
        int query(int node,int start,int end,int op ,int l,int r){
            if (l>end || r<start){
                return op==1 ? -1:0;
            }
            if (l<=start && end<-r){
                return tree[node][op+1];
            }
            int mid=(start+end)/2;
            int left=query(node*2,start,mid,op ,l, r);
            int right=query(node*2+1,mid+1,end,op ,l, r);
            if (op==1){
                if (left==-1){
                    return right;
                }
                if (right==-1){
                    return left;
                }
                return ((left & tree[2*node+1][1]) | (tree[2*node][0] & right));
            }
            else {
                return ((left | tree[2*node+1][0]) & (tree[2*node][1] | right));
            }
        }
    }

}
