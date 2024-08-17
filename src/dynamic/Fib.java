package dynamic;

/**
 * ClassName:Fib
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/18 16:08
 * @Version 1.0
 */
public class Fib {
    /*
    斐波那契数列的动态规划解法
     */
    public static int fib(int n) {
        int[] f=new int[n+2];//2是为了防止n=0，初始化异常
        //初始化
        f[0]=0;
        f[1]=1;
        //递推公式
        for (int i = 2; i <= n; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
    public static int fib2(int n) {
        int[] f=new int[n+3];//2是为了防止n=0，初始化异常
        //初始化
        f[0]=0;
        f[1]=1;
        f[2]=2;
        //递推公式
        for (int i = 3; i <= n; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
    public static void main(String[] args) {
        System.out.println(fib2(4));
    }
}
