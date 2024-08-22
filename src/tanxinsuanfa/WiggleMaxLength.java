package tanxinsuanfa;

import java.sql.SQLOutput;

/**
 * ClassName:WiggleMaxLength
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/22 8:28
 * @Version 1.0
 * 思路是判断节点和左边相减和右边相减是否不一样
 */
public class WiggleMaxLength {
    //默认最右面的算一个
    int result=1;
    //当做头结点
    int head=0;
    public int wiggleMaxLength(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if ((head<=0 && nums[i+1]-nums[i]>0) || (head>=0 && nums[i+1]-nums[i]<0)){
                result++;
            }
            head=nums[i+1]-nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new WiggleMaxLength().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
