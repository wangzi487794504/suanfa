package hash;

import org.junit.Test;

import java.util.HashSet;

/**
 * ClassName:IsHappy
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/7/30 21:08
 * @Version 1.0
 */
public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet();
        //首先要取位对应的字母
        while (n!=1 && !set.contains(n)){
            System.out.println(n);
            //为了防止无限循环，用一个set
            set.add(n);
            n=getByte(n);
        }
        return n==1;
    }
    public int getByte(int n){
        int sum=0;
        while (n>0){
            int temp=n%10;
            System.out.println("temp="+temp);
            sum+=temp*temp;
            n = n / 10;
        }
        //得到计算结果
        System.out.println("sum="+sum);
        return sum;
    }
    @Test
    public void test(){
        System.out.println(isHappy(19));
    }
}
