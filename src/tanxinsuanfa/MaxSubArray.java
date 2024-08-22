package tanxinsuanfa;

/**
 * ClassName:MaxSubArray
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/21 22:18
 * @Version 1.0
 */
public class MaxSubArray {
    int result=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp+=nums[i];
            if (temp>result){
                result=temp;
            }
            if (temp<0){
                temp=0;
            }
        }
        return result;
    }
}
