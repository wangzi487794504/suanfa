package dynamic;

/**
 * ClassName:FindMaxForm
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/9/12 14:28
 * @Version 1.0
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            int numZero=0;
            int numOne=0;
            for (int j = 0; j < temp.length; j++) {
                //统计i=0d的个数
                if (temp[j]=='0'){
                    numZero++;
                }
                else {
                    numOne++;
                }
            }
            //遍历dp
            for (int j = dp.length - 1; j >= numZero; j--) {
                for (int k = dp[j].length-1; k >=numOne ; k--) {
                    dp[j][k]=Math.max(dp[j][k],dp[j-numZero][k-numOne]+1);
                }
            }
        }
        return dp[m][n];
    }
}
class SibgleParttern{
    //定义静态单例变量
    private volatile static SibgleParttern sibgleParttern;
    //构造方法私有化
    private SibgleParttern(){
        synchronized (SibgleParttern.class){
            if (sibgleParttern!=null){
                System.out.println("反射破坏");
            }
        }
    }
    //todo 设置获取实例的方法
    public static SibgleParttern  getInstance(){
        if (sibgleParttern==null){
            synchronized (sibgleParttern){
                if (sibgleParttern==null){
                    sibgleParttern=new SibgleParttern();
                }
            }
        }
        return sibgleParttern;
    }
}
